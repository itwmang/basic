package com.wmang.logis.mode.utils.base;

import java.io.Serializable;

/**
 * Title:分页请求类
 * 
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown = true)
public class BasePageRequest extends BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

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

}
