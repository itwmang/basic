package com.wmang.logis.mode.utils.base;

import java.io.Serializable;
import java.util.List;

/**
 * @company 分页基础响应类
 * @Description: 分页基础响应类
 * 2015年5月25日 下午3:54:12 
 * @version 1.0 
 */
public class BasePageResponse extends BasicResponse implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = -8282921583302038221L;
    private int code;
    private String msg;
    private long count;
    private List<?> data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
