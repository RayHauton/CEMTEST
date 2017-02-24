package com.cem.pojo;
// Generated 2017-2-24 22:31:30 by Hibernate Tools 4.0.1.Final

/**
 * Forummodule generated by hbm2java
 */
public class Forummodule implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2054510988811157392L;
	private String forumModuleId;
	private String forumModuleName;
	private Integer forumCount;
	private String statement;
	private char isDeleted;

	public Forummodule() {
	}

	public Forummodule(String forumModuleId, char isDeleted) {
		this.forumModuleId = forumModuleId;
		this.isDeleted = isDeleted;
	}

	public Forummodule(String forumModuleId, String forumModuleName, Integer forumCount, String statement,
			char isDeleted) {
		this.forumModuleId = forumModuleId;
		this.forumModuleName = forumModuleName;
		this.forumCount = forumCount;
		this.statement = statement;
		this.isDeleted = isDeleted;
	}

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

	public Integer getForumCount() {
		return this.forumCount;
	}

	public void setForumCount(Integer forumCount) {
		this.forumCount = forumCount;
	}

	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public char getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}

}
