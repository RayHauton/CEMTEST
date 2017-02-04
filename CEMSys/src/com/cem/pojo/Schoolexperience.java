package com.cem.pojo;

/**
 * Schoolexperience entity. @author MyEclipse Persistence Tools
 */

public class Schoolexperience implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4701417665422963227L;
	private String seid;
	private String majorName;
	private String education;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Schoolexperience() {
	}

	/** full constructor */
	public Schoolexperience(String seid, String majorName, String education,
			String isDeleted) {
		this.seid = seid;
		this.majorName = majorName;
		this.education = education;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getSeid() {
		return this.seid;
	}

	public void setSeid(String seid) {
		this.seid = seid;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}