package com.wmang.logis.mode.utils;

import java.util.ArrayList;
import java.util.List;


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
}
