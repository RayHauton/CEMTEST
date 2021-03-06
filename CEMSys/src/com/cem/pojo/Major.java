package com.cem.pojo;
// Generated 2017-2-24 22:31:30 by Hibernate Tools 4.0.1.Final

/**
 * Major generated by hbm2java
 */
public class Major implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4999295679539023968L;
	private String majorId;
	private String majorName;
	private String isDeleted;

	public Major() {
	}

	public Major(String majorId) {
		this.majorId = majorId;
	}

	public Major(String majorId, String majorName, String isDeleted) {
		this.majorId = majorId;
		this.majorName = majorName;
		this.isDeleted = isDeleted;
	}

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
