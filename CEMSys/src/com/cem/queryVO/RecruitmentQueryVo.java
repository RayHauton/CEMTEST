package com.cem.queryVO;

/*
 * recruitment表查询条件的封装类
 */
public class RecruitmentQueryVo {
	private Integer pageIndex;
	private Integer pageSize;
	private Integer pageCount;
	private Integer recordCount;
	private String viewAll;
	private String publishPerson;
	private String pubForedate;
	private String pubAfterdate;
	private String pubCompany;

	public String getViewAll() {
		return viewAll;
	}

	public void setViewAll(String viewAll) {
		this.viewAll = viewAll;
	}

	public String getPublishPerson() {
		return publishPerson;
	}

	public void setPublishPerson(String publishPerson) {
		this.publishPerson = publishPerson;
	}

	public String getPubForedate() {
		return pubForedate;
	}

	public void setPubForedate(String pubForedate) {
		this.pubForedate = pubForedate;
	}

	public String getPubAfterdate() {
		return pubAfterdate;
	}

	public void setPubAfterdate(String pubAfterdate) {
		this.pubAfterdate = pubAfterdate;
	}

	public String getPubCompany() {
		return pubCompany;
	}

	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

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

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	private String queryCondition;
}
