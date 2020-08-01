package com.regex.admin.common.util;
/**
 * 分页请求
 * @author cgj
 *
 */
public class QueryParam {
	/**
	 * 当前页码
	 */
	private int pageNumber = 1;
	/**
	 * 起始条数
	 */
	private int startIndex;
	/**
	 * 单页大小
	 */
	private int pageSize;
	

	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
