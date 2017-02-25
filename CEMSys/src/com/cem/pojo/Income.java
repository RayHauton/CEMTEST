package com.cem.pojo;
// Generated 2017-2-24 22:31:30 by Hibernate Tools 4.0.1.Final

/**
 * Income generated by hbm2java
 */
public class Income implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4387556509823100268L;
	private String incomeId;
	private String incomeLevel;
	private String isDeleted;

	public Income() {
	}

	public Income(String incomeId, String incomeLevel, String isDeleted) {
		this.incomeId = incomeId;
		this.incomeLevel = incomeLevel;
		this.isDeleted = isDeleted;
	}

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
