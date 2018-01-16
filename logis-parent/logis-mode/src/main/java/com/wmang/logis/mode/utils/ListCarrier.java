package com.wmang.logis.mode.utils;

import java.util.ArrayList;
import java.util.List;

import com.wmang.logis.mode.utils.base.BasePageResponse;


/**
 * @Description 数组搬运工，封装一些基本操作
 * @author wmang
 * @date 2015年10月16日
 */
public abstract class ListCarrier<S,T> {
	
	public abstract T carry(S source) throws Exception ;
	
	public List<T> carryList(List<S> listSource) throws Exception {
		if (ValueUtil.isEmpty(listSource)) {
			return null;
		}
		List<T> listTarget=new ArrayList<T>();
		for (S t:listSource) {
			T v=carry(t);
			listTarget.add(v);
		}
		return listTarget;
	}
	
	public BasePageResponse<T> carryPage(BasePageResponse<S> pageSource) throws Exception {
		BasePageResponse<T> response=new BasePageResponse<T>();
		response.setTotal(0);
		//如果pageSource存在null的情况，应该先进行null判断才合理，拆分by pengjingya 2016-02-16
		if (pageSource==null) {
			return response;
		}
		/*
		 * 添加分页信息count,index,size
		 */
		response.setPageCount(pageSource.getPageCount());
		response.setPageIndex(pageSource.getPageIndex());
		response.setPageSize(pageSource.getPageSize());
		//拆分by pengjingya 2016-02-16
		if(ValueUtil.isEmpty(pageSource.getRows())){
			return response;
		}
		List<T> listTarget=new ArrayList<T>();
		for (S t:pageSource.getRows()) {
			T v=carry(t);
			listTarget.add(v);
		}
		response.setRows(listTarget);
		response.setTotal(pageSource.getTotal());
		return response;
	}
}
