package com.wmang.logis.mode.utils.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import com.wmang.logis.mode.utils.DateUtil;
import com.wmang.logis.mode.utils.base.CommonExample.Criteria;

public class PresetCriteria extends Criteria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2871812979417212307L;
	
	private static String mysqlDateFunc = "str_to_date";
	private static String mysqlDateFormat = "%Y-%m-%d %H:%i:%S";
	
	
	protected CommonExample example;
	public PresetCriteria(CommonExample example){
		this.example=example;
	}
	//测试的时候需要测试value中含有%，_之类的场景
	@Override
	public Criteria like(String andor, String columnName, int type, Object value) {
		String sql=getLikeSQL(andor, columnName, type, value);
		if(sql!=null){
			addCriterion(sql);
		}
		return this;
	
		
	};
	
	public String getLikeSQL(String andor, String columnName, int type, Object value){
		
		if (valueIsempty(value)) {
			return null;
		}
		String sql=null;
		boolean isContains = false;
		if (value.toString().contains("%")) {
			value = value.toString().replaceAll("%", "/%");
			isContains = true;
		}
		if (value.toString().contains("_")) {
			value = value.toString().replaceAll("_", "/_");
			isContains = true;
		}
		value="%"+value.toString().trim().replace("'","''")+"%";
		String placeHolder=this.getPlaceHolder(type,value);
		if(placeHolder==null){
			return sql;
		}
		//为什么要替换？待会儿再看
		//String类型的变量不要分开累加
		if (isContains) {
			sql = " "+andor+" "+columnName+" like "+placeHolder + " " + "escape '/'";
		}else{
			sql=" "+andor+" "+columnName+" like "+placeHolder+" ";
		}
		return sql;
		
	}
	@Override
	public Criteria likes(String andor, String columnName, int type, Object value) {
		if(valueIsempty(value)){
			return this;
		}
		StringBuilder builder=new StringBuilder();
		builder.append(" ").append(andor).append("(");
		boolean firstFlag=true;
		for (String str:value.toString().split(",")) {
			if (firstFlag) {
				firstFlag=false;
			} else {
				builder.append(" ").append(CommonExample.OR).append(" ");
			}
			String sql=this.getLikeSQL("", columnName, type, str);
			if(sql!=null){
				builder.append(sql);
				
			}
			
		}
		builder.append(" )");
		addCriterion(builder.toString());
		return this;
	}
	
	@Override
	public Criteria in(String andor, String colunnName, int type, Object value) {
		

		if(valueIsempty(value)){
			return (Criteria)this;
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(" ").append(andor).append(" ").append(colunnName).append(" in (");
		if (value instanceof Collection) {
			Collection<Object> collection=(Collection<Object>) value;
			Iterator<Object> iterator=collection.iterator();
			boolean isFirst=true;
			while(iterator.hasNext()){
				Object obj=iterator.next();
				String placeHolder=this.getPlaceHolder(type, obj);
				if(isFirst){
					sb.append(" ").append(placeHolder);
					isFirst=false;
				}else
					sb.append(" ,").append(placeHolder);
				
				
			}
		} else if(value.getClass().isArray()){
			Object[] array=(Object[]) value;
			boolean isFirst=true;
			for(Object obj:array){
				String placeHolder=this.getPlaceHolder(type, obj);
				if(isFirst){
					sb.append(" ").append(placeHolder);
					isFirst=false;
				}else
					sb.append(" ,").append(placeHolder);
			}
		}else {
			String[] arr=value.toString().trim().split(",");
			boolean isFirst=true;
			for(String s:arr){
				String placeHolder=this.getPlaceHolder(type, s);
				if(isFirst){
					sb.append(" ").append(placeHolder);
					isFirst=false;
				}else
					sb.append(" ,").append(placeHolder);
			}
			
		}
		sb.append(")");
		
		addCriterion(sb.toString());
		return (Criteria)this;
	
	}
	
	@Override
	public Criteria between(String andor, String columnName, int type, Object value1, Object value2) {
		String sql="";
		if (value1==null || value2==null) {
			return (Criteria)this;
		}
		String str1=getPlaceHolder(type,value1);
		String str2=getPlaceHolder(type,value2);
		if (str1==null||str2==null) {
			return (Criteria)this;
		}
		sql=" "+andor+" "+columnName+" between("+str1+" and "+str2+") ";
		
		addCriterion(sql);
		return (Criteria)this;
	}
	
	@Override
	public Criteria datebetween(String andor, String columnName, Object begindate, Object enddate) {

		String sql=null;
		if (begindate==null && enddate==null) {
			return (Criteria)this;
		}
		/*String bd=null;
		String ed=null;
		if (begindate!=null) {
			bd=transferTime(begindate," 00:00:00");
		}
		if (enddate!=null) {
			ed=transferTime(enddate," 00:00:00");
		}
		*/
		if (!valueIsempty(begindate) && valueIsempty(enddate)) {
			String placeHolder=this.getPlaceHolder(CommonExample.D, begindate);
			sql=" "+andor+" "+columnName+">= "+mysqlDateFunc+"("+placeHolder+",'"+mysqlDateFormat+"') ";
		} else if (valueIsempty(begindate) && !valueIsempty(enddate)) {
			String placeHolder=this.getPlaceHolder(CommonExample.D, enddate);
			sql=" "+andor+" "+columnName+"<= "+mysqlDateFunc+"("+placeHolder+",'"+mysqlDateFormat+"') ";
		} else if (!valueIsempty(begindate) && !valueIsempty(enddate)) {
			String placeHolder1=this.getPlaceHolder(CommonExample.D, begindate);
			String placeHolder2=this.getPlaceHolder(CommonExample.D, enddate);
			sql=" "+andor+" "+columnName+" >= "+mysqlDateFunc+"("+placeHolder1+",'"+mysqlDateFormat+"') and "+columnName+" <= "+mysqlDateFunc+"("+placeHolder2+",'"+mysqlDateFormat+"') ";
		}
		if(sql!=null){
			addCriterion(sql);
		}
		return (Criteria)this;
	
	}
	
	private boolean valueIsempty(Object value) {
		return value==null || "".equals(value);
	}
	@Override
	public Criteria common(String operate, String andor, String columnName, int type, Object value) {

		String sql=null;
		if (valueIsempty(value)) {
			return (Criteria)this;
		}
		if (value instanceof String&&((String) value).length()<1) {
			return (Criteria)this;
		}
		if(type==CommonExample.D){
			sql=" "+andor+" "+columnName+operate+" to_date("+getPlaceHolder(type,value)+",'yyyy-mm-dd hh24:mi:ss') ";
		}else{
			sql=" "+andor+" "+columnName+operate+getPlaceHolder(type,value)+" ";
		}
		if(sql!=null){
			addCriterion(sql);
		}
		return (Criteria)this;
	
	}
	private String transferTime(Object obj,String attachment) {
		String date_str=null;
		if ((obj instanceof String)&&(obj.toString().trim().length()>0)) {
			if (CommonExample.datepattern.matcher(obj.toString()).matches()) {
				date_str=obj+" 00:00:00";
			} else if (CommonExample.datetimepattern.matcher(obj.toString()).matches()) {
				date_str=obj.toString();
			} else {
				boolean flag=true;
				for (char c:((String) obj).toCharArray()) {
					if (c>='0'&&c<='9') {
						continue;
					} else {
						flag=false;
						break;
					}
				}
				if (flag) {
					date_str=DateUtil.format(new Date(Long.parseLong(obj.toString())), DateUtil.h_yyyy_MM_dd_HH_mm_ss);
				}
			}
			
		} else if (obj instanceof Date) {
			date_str=DateUtil.format((Date) obj, DateUtil.h_yyyy_MM_dd_HH_mm_ss);
		} else if ((obj instanceof Integer)||(obj instanceof Long)) {
			date_str=DateUtil.format(new Date(Long.parseLong(obj.toString())), DateUtil.h_yyyy_MM_dd_HH_mm_ss);
		}
		return date_str;
	}
	//将具体值用占位符代替
	public String getPlaceHolder(int type,Object value){
		if(valueIsempty(value)){
			return null;
		}
		String placeHolder=null;
		String uuid=null;
		if (type==CommonExample.V) {
			uuid=UUID.randomUUID().toString();
			placeHolder="#{"+uuid+",jdbcType=VARCHAR}";
		}else if(type==CommonExample.D){
			value=transferTime(value," 00:00:00");
			if(value!=null){
				uuid=UUID.randomUUID().toString();
				placeHolder="#{"+uuid+",jdbcType=VARCHAR}";
			}
		}else if(type==CommonExample.N){
			uuid=UUID.randomUUID().toString();
			placeHolder="#{"+uuid+",jdbcType=NUMERIC}";
			value=Integer.parseInt(value.toString());
		}else{
			//其他类型得数据不予处理
			return placeHolder;
		}
		if(uuid!=null){
			example.setMap(uuid, value);
		}
		return placeHolder;
	}
	
	
}
