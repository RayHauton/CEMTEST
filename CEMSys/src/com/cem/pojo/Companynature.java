package com.cem.pojo;

/**
 * Companynature entity. @author MyEclipse Persistence Tools
 */

public class Companynature implements java.io.Serializable {

	// Fields

	private String natureId;
	private String natureName;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Companynature() {
	}

	/** full constructor */
	public Companynature(String natureId, String natureName, String isDeleted) {
		this.natureId = natureId;
		this.natureName = natureName;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getNatureId() {
		return this.natureId;
	}

	public void setNatureId(String natureId) {
		this.natureId = natureId;
	}

	public String getNatureName() {
		return this.natureName;
	}

	public void setNatureName(String natureName) {
		this.natureName = natureName;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}