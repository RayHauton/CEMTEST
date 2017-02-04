package com.cem.pojo;

/**
 * Companynature entity. @author MyEclipse Persistence Tools
 */

public class Companynature implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4724680096401499835L;
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