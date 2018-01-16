package com.wmang.logis.mode.utils.base;

import java.io.Serializable;
import java.util.List;

/**
 * @company 东软集团股份有限公司
 * @Description: 分页基础响应类
 * 2015年5月25日 下午3:54:12 
 * @version 1.0 
 */
public class BasePageResponse<T> extends BasicResponse implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = -8282921583302038221L;
	private Integer pageIndex;// 分页索引,#从1开始
	private Integer pageSize;// 分页大小,
	private Integer pageCount;// 分页总数,
	private Integer total;//总数
	private List<T> rows;// 数据列表

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
