package com.cem.pojo;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private String majorId;
	private String majorName;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(String majorId) {
		this.majorId = majorId;
	}

	/** full constructor */
	public Major(String majorId, String majorName, String isDeleted) {
		this.majorId = majorId;
		this.majorName = majorName;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}