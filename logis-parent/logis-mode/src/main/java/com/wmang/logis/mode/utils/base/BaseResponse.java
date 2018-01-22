package com.wmang.logis.mode.utils.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wmang
 * @version 1.0
 */
public class BaseResponse<T> extends BasicResponse implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 8913107009427739407L;

	private T returnObject;

	private int pageIndex;
	private int pageSize;

	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	private List<T> list;// 数据列表

	public List<T> getList() {
		if (list == null)
			list = new ArrayList<T>();
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(T returnObject) {
		this.returnObject = returnObject;
	}
}
