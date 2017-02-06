package com.cem.pojo;

/**
 * Bbsrank entity. @author MyEclipse Persistence Tools
 */

public class Bbsrank implements java.io.Serializable {

	// Fields

	private String rankId;
	private String rankName;
	private String icon;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Bbsrank() {
	}

	/** minimal constructor */
	public Bbsrank(String rankId, String isDeleted) {
		this.rankId = rankId;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Bbsrank(String rankId, String rankName, String icon, String isDeleted) {
		this.rankId = rankId;
		this.rankName = rankName;
		this.icon = icon;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getRankId() {
		return this.rankId;
	}

	public void setRankId(String rankId) {
		this.rankId = rankId;
	}

	public String getRankName() {
		return this.rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}