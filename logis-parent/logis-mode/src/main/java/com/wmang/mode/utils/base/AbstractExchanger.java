package com.wmang.mode.utils.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 数据交换类，目前为DB类与VO类的交换
 * @department 东软集团_流程IT_售后系统_电子商务产品
 * @author 陈志光
 * @date 2015年12月25日
 */
public abstract class AbstractExchanger<V,D> {
	
	public abstract V newInstanceV();
	
	public abstract D newInstanceD();
	
	public abstract void dbFillVo(D db,V vo);
	
	public abstract void voFillDb(V vo,D db);
	
	public abstract void mapFillVo(Map<String,?> map,V vo);
	
	public abstract void dbFillPkVo(D db,V vo);
	
	public V dbToVo(D db) {
		V vo=newInstanceV();
		dbFillVo(db,vo);
		return vo;
	}
	
	public D voToDb(V vo) {
		D db=newInstanceD();
		voFillDb(vo,db);
		return db;
	}
	
	public V mapToVo(Map<String,?> map) {
		V vo=newInstanceV();
		mapFillVo(map,vo);
		return vo;
	}
	
	public List<V> listMapToVo(List<D> listDB) {
		if (listDB!=null&&listDB.size()>0) {
			List<V> listVO=new ArrayList<V>();
			for (D db:listDB) {
				listVO.add(dbToVo(db));
			}
			return listVO;
		}
		return null;
	}
	
}
