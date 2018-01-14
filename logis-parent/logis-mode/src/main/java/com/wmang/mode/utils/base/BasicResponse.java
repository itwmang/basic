package com.wmang.mode.utils.base;

import java.io.Serializable;

/**
 * @author wmang
 * @version 1.0 
 */
public class BasicResponse implements Serializable{
	
	private static final long serialVersionUID = 8717181836679945499L;
	private Boolean status = true;
	private String errorCode;
	private String errorMsg;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
