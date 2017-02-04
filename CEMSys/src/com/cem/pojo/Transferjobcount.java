package com.cem.pojo;

/**
 * Transferjobcount entity. @author MyEclipse Persistence Tools
 */

public class Transferjobcount implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2682644121708546871L;
	private String countId;
	private String countLabel;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Transferjobcount() {
	}

	/** full constructor */
	public Transferjobcount(String countId, String countLabel, String isDeleted) {
		this.countId = countId;
		this.countLabel = countLabel;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getCountId() {
		return this.countId;
	}

	public void setCountId(String countId) {
		this.countId = countId;
	}

	public String getCountLabel() {
		return this.countLabel;
	}

	public void setCountLabel(String countLabel) {
		this.countLabel = countLabel;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}