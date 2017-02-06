package com.cem.pojo;

/**
 * Degree entity. @author MyEclipse Persistence Tools
 */

public class Degree implements java.io.Serializable {

	// Fields

	private String degreeId;
	private String degreeName;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Degree() {
	}

	/** full constructor */
	public Degree(String degreeId, String degreeName, String isDeleted) {
		this.degreeId = degreeId;
		this.degreeName = degreeName;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}