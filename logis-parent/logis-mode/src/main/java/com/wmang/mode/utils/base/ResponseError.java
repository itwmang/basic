package com.wmang.mode.utils.base;

import java.io.Serializable;

public class ResponseError implements Serializable{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 4663845900653382449L;
	/** 错误代码 */
	private String errCode;
	/** 错误消息*/
	private String errMsg;
	/** 详细消息 */
	private String detailMsg;
	
	private String zhMsg;
	private String zhDetailMsg;
	
	public String getZhMsg() {
		return zhMsg;
	}

	public void setZhMsg(String zhMsg) {
		this.zhMsg = zhMsg;
	}

	public String getZhDetailMsg() {
		return zhDetailMsg;
	}

	public void setZhDetailMsg(String zhDetailMsg) {
		this.zhDetailMsg = zhDetailMsg;
	}

	public String getDetailMsg() {
		return detailMsg;
	}

	public void setDetailMsg(String detailMsg) {
		this.detailMsg = detailMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrorCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
