package com.cem.pojo;
/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private String topicId;
	private String topicName;
	private String description;
	private String sequence;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(String topicId, String isDeleted) {
		this.topicId = topicId;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Topic(String topicId, String topicName, String description,
			String sequence, String isDeleted) {
		this.topicId = topicId;
		this.topicName = topicName;
		this.description = description;
		this.sequence = sequence;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSequence() {
		return this.sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}