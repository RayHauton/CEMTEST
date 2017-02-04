package com.cem.pojo;

/**
 * Forum entity. @author MyEclipse Persistence Tools
 */

public class Forum implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 572852796722790496L;
	private String forumId;
	private String forumTitle;
	private String forumModule;
	private String userId;
	private String username;
	private String topic;
	private String publishTime;
	private String updateTime;
	private Integer replyCount;
	private Integer viewCount;
	private String attachment;
	private String isFine;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Forum() {
	}

	/** minimal constructor */
	public Forum(String forumId, String isDeleted) {
		this.forumId = forumId;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Forum(String forumId, String forumTitle, String forumModule,
			String userId, String username, String topic, String publishTime,
			String updateTime, Integer replyCount, Integer viewCount,
			String attachment, String isFine, String isDeleted) {
		this.forumId = forumId;
		this.forumTitle = forumTitle;
		this.forumModule = forumModule;
		this.userId = userId;
		this.username = username;
		this.topic = topic;
		this.publishTime = publishTime;
		this.updateTime = updateTime;
		this.replyCount = replyCount;
		this.viewCount = viewCount;
		this.attachment = attachment;
		this.isFine = isFine;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getForumId() {
		return this.forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getForumTitle() {
		return this.forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public String getForumModule() {
		return this.forumModule;
	}

	public void setForumModule(String forumModule) {
		this.forumModule = forumModule;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getReplyCount() {
		return this.replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getIsFine() {
		return this.isFine;
	}

	public void setIsFine(String isFine) {
		this.isFine = isFine;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}