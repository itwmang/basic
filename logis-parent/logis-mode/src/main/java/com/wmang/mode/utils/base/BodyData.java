package com.wmang.mode.utils.base;

import java.io.Serializable;

/**
 * @Description
 * @department 东软集团_流程IT_售后系统_CSS产品
 * @author 李强
 * @date 2015年11月25日
 */
public class BodyData implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 5966368495469045475L;

	private Boolean status = true;

	/**
	 * 响应报文
	 */
	private Object content;
	
	/**
	 * 错误信息,格式为:{msg:'no data';errorCode:"100"}
	 */
	private ResponseError error;

	public static BodyData make(Boolean status) {
		BodyData rb = new BodyData();
		rb.setStatus(status);
		return rb;
	}
	
	public ResponseError getError() {
		return error;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	public void setError(String errorCode, String errorMsg) {
		setError(errorCode, errorMsg, null);
	}

	public void setError(String errorCode, String errorMsg, String detailMsg) {
		if (error == null) {
			error = new ResponseError();
		}
		error.setErrCode(errorCode);
		error.setErrMsg(errorMsg);
		error.setDetailMsg(detailMsg);
	}
}
