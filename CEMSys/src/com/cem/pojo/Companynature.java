package com.cem.pojo;
// Generated 2017-2-24 22:31:30 by Hibernate Tools 4.0.1.Final

/**
 * Companynature generated by hbm2java
 */
public class Companynature implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736827183338967283L;
	private String natureId;
	private String natureName;
	private char isDeleted;

	public Companynature() {
	}

	public Companynature(String natureId, String natureName, char isDeleted) {
		this.natureId = natureId;
		this.natureName = natureName;
		this.isDeleted = isDeleted;
	}

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

	public char getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}

}
