package com.wmang.mode.utils.base;

import java.util.List;

/**
 * @Description 管理Biz类
 * @department 东软集团_流程IT_售后系统_电子商务产品
 * @author 陈志光
 * @date 2015年12月25日
 */
public abstract class AbstractBaseMgrBiz<V,D,P> implements BaseMgrBiz<V, P> {

	/**
	 * @Description 获取Service类
	 */
	public abstract BaseService<D, P> getBaseService();
	
	/**
	 * @Description 获取VO与DB的交换类
	 */
	public abstract AbstractExchanger<V,D> getExchanger();
	
	/**
	 * @Description 获取更新的列
	 */
	public abstract List<String> getUpdateColumns();
	
	@Override
	public BaseResponse<V> findOne(P id) throws Exception {
		BaseResponse<V> response=new BaseResponse<V>();
		D db=this.getBaseService().findOne(id);
		if (db!=null) {
			response.setReturnObject(getExchanger().dbToVo(db));
		}
		return response;
	}

	@Override
	public BaseResponse<V> save(V vo, String userId) throws Exception {
		BaseResponse<V> response=new BaseResponse<V>();
		D db=this.getBaseService().save(getExchanger().voToDb(vo));
		if (db!=null) {
			getExchanger().dbFillPkVo(db, vo);
			response.setReturnObject(vo);
		}
		return response;
	}
	
	@Override
	public BaseResponse<V> insertWithSequence(V vo, String userId) throws Exception {
		BaseResponse<V> response=new BaseResponse<V>();
		D db=this.getBaseService().insertWithSequence(getExchanger().voToDb(vo));
		if (db!=null) {
			getExchanger().dbFillPkVo(db, vo);
			response.setReturnObject(vo);
		}
		return response;
	}

	@Override
	public BaseResponse<V> update(V vo, String userId) throws Exception {
		BaseResponse<V> response=new BaseResponse<V>();
		D db=this.getBaseService().updateSelected(getExchanger().voToDb(vo),getUpdateColumns());
		if (db!=null) {
			getExchanger().dbFillPkVo(db, vo);
			response.setReturnObject(vo);
		}
		return response;
	}

	@Override
	public BaseResponse<List<P>> delete(List<P> ids, String userId) throws Exception {
		BaseResponse<List<P>> response=new BaseResponse<List<P>>();
		for (P id:ids) {
			this.getBaseService().delete(id);
		}
		response.setReturnObject(ids);
		return response;
	}
	
}
