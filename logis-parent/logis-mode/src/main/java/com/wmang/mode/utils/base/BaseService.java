package com.wmang.mode.utils.base;

import java.util.List;

public interface BaseService<D,P> {
	public D findOne(P id) throws Exception;
	
	public D save(D vo) throws Exception;
	
	/** 新增自带序列 */
	public D insertWithSequence(D record) throws Exception;
	
	public D update(D vo) throws Exception;
	
	public D updateSelected(D vo,List<String> columns) throws Exception;
	
	public P delete(P id) throws Exception;
	
	public List<D> listByCondition(CommonExample example) throws Exception;
	
	public Integer countByCondition(CommonExample example) throws Exception;
}
