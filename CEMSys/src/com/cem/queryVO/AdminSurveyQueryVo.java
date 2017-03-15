package com.cem.queryVO;

public class AdminSurveyQueryVo {

	private String titleNum;
	private String scoreNum;
	private Integer pageIndex;
	private Integer pageSize;
	public String getTitleNum() {
		return titleNum;
	}
	public void setTitleNum(String titleNum) {
		this.titleNum = titleNum;
	}
	public String getScoreNum() {
		return scoreNum;
	}
	public void setScoreNum(String scoreNum) {
		this.scoreNum = scoreNum;
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

}
