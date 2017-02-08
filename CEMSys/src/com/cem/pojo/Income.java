package com.cem.pojo;

/**
 * Income entity. @author MyEclipse Persistence Tools
 */

public class Income implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7103228453015368809L;
	private String incomeId;
	private String incomeLevel;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Income() {
	}

	/** full constructor */
	public Income(String incomeId, String incomeLevel, String isDeleted) {
		this.incomeId = incomeId;
		this.incomeLevel = incomeLevel;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getIncomeId() {
		return this.incomeId;
	}

	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}

	public String getIncomeLevel() {
		return this.incomeLevel;
	}

	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}