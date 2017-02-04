package com.cem.pojo;

/**
 * Forummodule entity. @author MyEclipse Persistence Tools
 */

public class Forummodule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6632736163697896721L;
	private String forumModuleId;
	private String forumModuleName;
	private Long forumCount;
	private String statement;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Forummodule() {
	}

	/** minimal constructor */
	public Forummodule(String forumModuleId, String isDeleted) {
		this.forumModuleId = forumModuleId;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Forummodule(String forumModuleId, String forumModuleName,
			Long forumCount, String statement, String isDeleted) {
		this.forumModuleId = forumModuleId;
		this.forumModuleName = forumModuleName;
		this.forumCount = forumCount;
		this.statement = statement;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getForumModuleId() {
		return this.forumModuleId;
	}

	public void setForumModuleId(String forumModuleId) {
		this.forumModuleId = forumModuleId;
	}

	public String getForumModuleName() {
		return this.forumModuleName;
	}

	public void setForumModuleName(String forumModuleName) {
		this.forumModuleName = forumModuleName;
	}

	public Long getForumCount() {
		return this.forumCount;
	}

	public void setForumCount(Long forumCount) {
		this.forumCount = forumCount;
	}

	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}