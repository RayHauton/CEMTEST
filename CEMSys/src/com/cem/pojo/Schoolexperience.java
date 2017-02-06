package com.cem.pojo;

/**
 * Schoolexperience entity. @author MyEclipse Persistence Tools
 */

public class Schoolexperience implements java.io.Serializable {

	// Fields

	private String schooleExperienceId;
	private String majorId;
	private String degreeId;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Schoolexperience() {
	}

	/** full constructor */
	public Schoolexperience(String schooleExperienceId, String majorId,
			String degreeId, String isDeleted) {
		this.schooleExperienceId = schooleExperienceId;
		this.majorId = majorId;
		this.degreeId = degreeId;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getSchooleExperienceId() {
		return this.schooleExperienceId;
	}

	public void setSchooleExperienceId(String schooleExperienceId) {
		this.schooleExperienceId = schooleExperienceId;
	}

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}