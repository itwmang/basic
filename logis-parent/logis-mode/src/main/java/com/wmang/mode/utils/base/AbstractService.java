package com.wmang.mode.utils.base;

import java.util.List;


public abstract class AbstractService<D,P> implements BaseService<D, P> {
	
	public abstract BaseMapper<D,P> getBaseMapper() throws Exception;
	
	public D findOne(P id) throws Exception {
		return getBaseMapper().findOne(id);
	}
	
	public D save(D db) throws Exception {
		getBaseMapper().save(db);
		return db;
	}
	
	public D insertWithSequence(D db) throws Exception {
		getBaseMapper().insertWithSequence(db);
		return db;
	}
	
	public D update(D db) throws Exception {
		getBaseMapper().update(db);
		return db;
	}
	
	public D updateSelected(D db,List<String> columns) throws Exception {
		getBaseMapper().updateSelected(db, columns);
		return db;
	}
	
	public P delete(P id) throws Exception {
		getBaseMapper().delete(id);
		return id;
	}
	
	public List<D> listByCondition(CommonExample example) throws Exception {
		return getBaseMapper().listByCondition(example);
	}
	
	public Integer countByCondition(CommonExample example) throws Exception {
		return null == getBaseMapper().countByCondition(example)?0:getBaseMapper().countByCondition(example);
	}
}
