package com.wmang.logis.mode.dto.request.user;

import java.io.Serializable;

import com.wmang.logis.mode.utils.base.BaseRequest;

/**
 * Title: 客户主数据 Description: 客户主数据VO类
 * 
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown = true)
public class SysUserRequest extends BaseRequest implements Serializable {

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
