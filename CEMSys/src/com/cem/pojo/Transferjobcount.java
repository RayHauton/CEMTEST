package com.cem.pojo;
// Generated 2017-2-24 22:31:30 by Hibernate Tools 4.0.1.Final

/**
 * Transferjobcount generated by hbm2java
 */
public class Transferjobcount implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -814546333898255095L;
	private String countId;
	private String countLabel;
	private String isDeleted;

	public Transferjobcount() {
	}

	public Transferjobcount(String countId, String countLabel, String isDeleted) {
		this.countId = countId;
		this.countLabel = countLabel;
		this.isDeleted = isDeleted;
	}

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
