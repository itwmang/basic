package com.wmang.logis.mode.interceptor;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.CollectionUtils;

import com.wmang.logis.mode.utils.base.BaseInterceptor;
import com.wmang.logis.mode.utils.base.CommonExample;

@Intercepts({  
    @Signature(type = Executor.class, method = "query", args = {  
            MappedStatement.class, Object.class ,RowBounds.class,  
            ResultHandler.class}) ,@Signature(type = Executor.class, method = "update", args = {  
                    MappedStatement.class, Object.class})}) 
public class PresetInterceptor extends BaseInterceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args=invocation.getArgs();
		if(args[0]==null || args[1]==null){
			return invocation.proceed();
		}
		CommonExample example=null;
		Map<String,Object> map=null;
		//参数有注解或者有多个参数都将用ParamMap将参数进行封装
		if(args[1] instanceof ParamMap<?>){
			//用递归处理嵌套CommonExample的参数
			map=new HashMap<String,Object>();
			//为了防止有人不用example作为属性,索性直接遍历map中的对象
			ParamMap<?> paramMap=(ParamMap<?>) args[1];
			map=trasferMap(paramMap,map);
			
			//防止有人没用参数注解而直接传参
		}else if(args[1] instanceof CommonExample){
			example=(CommonExample) args[1];
			if(example.isUsePreset()){
				map=new HashMap<String,Object>();
				map.putAll(example.getMap());
			}
			
		}else if(args[1] instanceof Collection){
			Collection<?> col=(Collection<?>) args[1];
			Iterator<?> iterator=col.iterator();
			Object ob=null;
			while(iterator.hasNext()){
				ob=iterator.next();
				if(ob instanceof CommonExample){
					example=(CommonExample) ob;
					if(example.isUsePreset()){
						if(map==null){
							map=new HashMap<String,Object>();
						}
						map.putAll(example.getMap());
					}else{
						break;
					}
					
				}else{
					break;
				}
			}
		}
		
		MappedStatement ms=(MappedStatement) args[0];
		BoundSql boundSql=ms.getBoundSql(args[1]);
		//TODO:注释权限过滤转换
//		boolean isPermmisionSqlSource=(ms.getSqlSource() instanceof BaseSqlInterceptor.BoundSqlSqlSource);
//		if(isPermmisionSqlSource){
//			boundSql=ms.getSqlSource().getBoundSql(args[1]);
//		}else{
//			boundSql=ms.getBoundSql(args[1]);
//		}
		
		String sql=boundSql.getSql();
		//RawSqlSource中的SQKSOURCE实际上就是staticSqlSource,而staticSqlSource的getBoundSql每次都会重新new BoundSql,导致原本已经被赋值的AdditionalParameter被清空
		//所以为了为了BoundSql中的AdditionalParameter不被清空，唯有使用原有的BoundSql，即使用自定义的BoundSqlSqlSource
		//由于需要遍历SQL中#{和}是否配对，需要做大量的查询，这里不采用这种方式，直接new RawSqlSource减少错误
		SqlSource sqlSource=new RawSqlSource(ms.getConfiguration(), sql,args[1].getClass());
		BoundSql new_boundSql=sqlSource.getBoundSql(args[1]);
		String newSql=new_boundSql.getSql();
		if(map!=null && !map.isEmpty()){
			for(String key:map.keySet()){
				boundSql.setAdditionalParameter(key, map.get(key));
			}
		}
		
		List<ParameterMapping> mappings=new ArrayList<ParameterMapping>();
		//更新的时候使用commonexample一定是动态SQL，通过RawSqlSource后List<ParameterMapping>一定是没有数据的，即new_boundSql.getParameterMappings()为空
		//若SQL不经过权限拦截器，获取的SQL也是不包含占位符的，即new_boundSql.getParameterMappings()为空
		//若 经过拦截器，参数中无论是否包含commonexample，则SQL所有参值应该是用#{}代替
		if(!CollectionUtils.isEmpty(boundSql.getParameterMappings())){
			mappings.addAll(boundSql.getParameterMappings());
		}
		//TODO:注释权限过滤转换
//		if(isPermmisionSqlSource){
//			BaseSqlInterceptor.BoundSqlSqlSource temp_=(BaseSqlInterceptor.BoundSqlSqlSource)ms.getSqlSource();
//			Map<String,Object> map1=temp_.getMap();
//			if(map1!=null){
//				for(Entry<String, Object> entry:map1.entrySet()){
//					boundSql.setAdditionalParameter(entry.getKey(), entry.getValue());
//				}
//			}
//		}
		if(!CollectionUtils.isEmpty(new_boundSql.getParameterMappings())){
			mappings.addAll(new_boundSql.getParameterMappings());
			
		}
		sqlSource.getBoundSql(args[1]).getParameterMappings();
		MappedStatement new_ms=super.newMappedStatement(ms, new BoundSqlSqlSource(boundSql));
		MetaObject ms_obj=MetaObject.forObject(new_ms, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		ms_obj.setValue(BOUND_SQL, newSql);
		ms_obj.setValue(BOUND_SQL_MAPPINGS, mappings);
		args[0]=new_ms;
		return invocation.proceed();
	}

	private Map<String, Object> trasferMap(Map<?, ?> temp_map,Map<String, Object> map) {
		Set<?> set=temp_map.keySet();
		CommonExample example=null;
		for(Object o:set){
			Object value=temp_map.get(o);
			if(value instanceof CommonExample){
				example=(CommonExample) value;
				
				if(example.getMap()!=null && example.isUsePreset()){
					map.putAll(example.getMap());
				}
				
			}else if(value instanceof Map){
				Map<?, ?> _map=(Map<?, ?>) value;
				trasferMap(_map,map);
			}else if(value instanceof Collection){
				Collection<?> col=(Collection<?>) value;
				Iterator<?> iterator=col.iterator();
				Object ob=null;
				while(iterator.hasNext()){
					ob=iterator.next();
					if(ob instanceof CommonExample){
						example=(CommonExample) ob;
						if(example.getMap()!=null && example.isUsePreset()){
							map.putAll(example.getMap());
						}
					}else{
						break;
					}
				}
			}
		}
		return map;
	}

	public static SqlSource newSqlSource(Configuration configuration, String sql, Class<?> parameterType){
		SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
	    Class<?> clazz = parameterType == null ? Object.class : parameterType;
		return sqlSourceParser.parse(sql, clazz, new HashMap<String, Object>());
	}

}
