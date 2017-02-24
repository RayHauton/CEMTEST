package com.cem.queryVO;

/*
 * Donation查询条件实体类
 */
public class DonationQueryVo {
	private String truename;// 捐赠人姓名
	private String donationProject;// 捐赠用途（捐赠的项目）
	private String donationType;// 捐赠东西的类别
	private String foredate;// 捐赠起始时间
	private String afterdate;// 捐赠结束时间
	private Integer pageIndex;
	private Integer pageSize;
	private Integer pageCount;
	private Integer recordCount;

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getDonationProject() {
		return donationProject;
	}

	public void setDonationProject(String donationProject) {
		this.donationProject = donationProject;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getForedate() {
		return foredate;
	}

	public void setForedate(String foredate) {
		this.foredate = foredate;
	}

	public String getAfterdate() {
		return afterdate;
	}

	public void setAfterdate(String afterdate) {
		this.afterdate = afterdate;
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

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
}
