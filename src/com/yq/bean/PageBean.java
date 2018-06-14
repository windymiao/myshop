package com.yq.bean;

import java.util.List;

public class PageBean {

	private int rowCount;
	private int pageSize=1;
	private int pageNow;
	private int pageCount;
	private List list;

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		setPageCount();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setPageCount();
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount() {
		this.pageCount = this.rowCount % this.pageSize == 0 ? this.rowCount
				/ this.pageSize : this.rowCount / this.pageSize + 1;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
