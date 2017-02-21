package com.cem.pojo;

import java.util.Date;

/**
 * Recruitment entity. @author MyEclipse Persistence Tools
 */

public class Recruitment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3681891629135499145L;
	private Long recruitmentId;
	private Long userId;
	private String truename;
	private Date publishDate;
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
	public Recruitment(Long recruitmentId, Long userId, Date publishDate, String companyName, String summary,
			String connectWay, String attachmentPath, String isDeleted) {
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

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public Long getRecruitmentId() {
		return recruitmentId;
	}

	public void setRecruitmentId(Long recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
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