package com.cem.pojo;

/**
 * Donation entity. @author MyEclipse Persistence Tools
 */

public class Donation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2241221741553740228L;
	private Long donationId;
	private Long publishUserId;
	private String publishUser;
	private String donationProject;
	private String donationItem;
	private String donor;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Donation() {
	}

	/** minimal constructor */
	public Donation(Long donationId, String publishUser, String donor,Long publishUserId,
			String isDeleted) {
		this.donationId = donationId;
		this.publishUser = publishUser;
		this.publishUserId=publishUserId;
		this.donor = donor;
		this.isDeleted = isDeleted;
	}

	public Long getPublishUserId() {
		return publishUserId;
	}

	public void setPublishUserId(Long publishUserId) {
		this.publishUserId = publishUserId;
	}

	/** full constructor */
	public Donation(Long donationId, String publishUser,Long publishUserId,
			String donationProject, String donationItem, String donor,
			String isDeleted) {
		this.donationId = donationId;
		this.publishUser = publishUser;
		this.publishUserId=publishUserId;
		this.donationProject = donationProject;
		this.donationItem = donationItem;
		this.donor = donor;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public Long getDonationId() {
		return this.donationId;
	}

	public void setDonationId(Long donationId) {
		this.donationId = donationId;
	}

	public String getPublishUser() {
		return this.publishUser;
	}

	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}

	public String getDonationProject() {
		return this.donationProject;
	}

	public void setDonationProject(String donationProject) {
		this.donationProject = donationProject;
	}

	public String getDonationItem() {
		return this.donationItem;
	}

	public void setDonationItem(String donationItem) {
		this.donationItem = donationItem;
	}

	public String getDonor() {
		return this.donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}