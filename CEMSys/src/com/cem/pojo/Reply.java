package com.cem.pojo;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2910354075122604764L;
	private Long replyId;
	private String replyText;
	private String publishUser;
	private String forum;
	private Short floor;
	private String replyTime;
	private String parentReplyId;
	private String replyObject;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(Long replyId, String isDeleted) {
		this.replyId = replyId;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Reply(Long replyId, String replyText, String publishUser,
			String forum, Short floor, String replyTime, String parentReplyId,
			String replyObject, String isDeleted) {
		this.replyId = replyId;
		this.replyText = replyText;
		this.publishUser = publishUser;
		this.forum = forum;
		this.floor = floor;
		this.replyTime = replyTime;
		this.parentReplyId = parentReplyId;
		this.replyObject = replyObject;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public Long getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public String getReplyText() {
		return this.replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getPublishUser() {
		return this.publishUser;
	}

	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}

	public String getForum() {
		return this.forum;
	}

	public void setForum(String forum) {
		this.forum = forum;
	}

	public Short getFloor() {
		return this.floor;
	}

	public void setFloor(Short floor) {
		this.floor = floor;
	}

	public String getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getParentReplyId() {
		return this.parentReplyId;
	}

	public void setParentReplyId(String parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	public String getReplyObject() {
		return this.replyObject;
	}

	public void setReplyObject(String replyObject) {
		this.replyObject = replyObject;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}