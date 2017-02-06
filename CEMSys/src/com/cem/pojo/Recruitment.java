package com.cem.pojo;

/**
 * Recruitment entity. @author MyEclipse Persistence Tools
 */

public class Recruitment implements java.io.Serializable {

	// Fields

	private String recruitmentId;
	private String userId;
	private String publishDate;
	private String companyName;
	private String summary;
	private String connectWay;
	private String attachmentPath;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Recruitment() {
	}

	/** full constructor */
	public Recruitment(String recruitmentId, String userId, String publishDate,
			String companyName, String summary, String connectWay,
			String attachmentPath, String isDeleted) {
		this.recruitmentId = recruitmentId;
		this.userId = userId;
		this.publishDate = publishDate;
		this.companyName = companyName;
		this.summary = summary;
		this.connectWay = connectWay;
		this.attachmentPath = attachmentPath;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getRecruitmentId() {
		return this.recruitmentId;
	}

	public void setRecruitmentId(String recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getConnectWay() {
		return this.connectWay;
	}

	public void setConnectWay(String connectWay) {
		this.connectWay = connectWay;
	}

	public String getAttachmentPath() {
		return this.attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}