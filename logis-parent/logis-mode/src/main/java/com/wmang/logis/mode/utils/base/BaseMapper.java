package com.wmang.logis.mode.utils.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T,P> {

	/** 根据id获取 */
	public T findOne(P pk) throws Exception;

	/** 新增 */
	public int save(T record) throws Exception;
	
	/** 新增自带序列 */
	public int insertWithSequence(T record) throws Exception;
	
	/** 更新 */
	public int update(T record) throws Exception;
	
	/** 删除 */
	public int delete(P pk) throws Exception;
	
	/** 更新所需字段 */
	public int updateSelected(@Param("record") T record,@Param("columns") List<String> columns) throws Exception;
	
	/** 根据条件查询数据库 */
	public List<T> listByCondition(@Param("example") CommonExample example) throws Exception;
	
	/** 根据条件查询数量 */
	public Integer countByCondition(@Param("example") CommonExample example) throws Exception;
	
}