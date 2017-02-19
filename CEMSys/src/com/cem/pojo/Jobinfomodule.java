package com.cem.pojo;

/**
 * Jobinfomodule entity. @author MyEclipse Persistence Tools
 */

public class Jobinfomodule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5174713523789199612L;
	private int moduleId;
	private String userId;
	private String companyNature;
	private String jobRank;
	private String companyName;
	private String positionName;
	private String resume;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Jobinfomodule() {
	}

	/** minimal constructor */
	public Jobinfomodule(int moduleId, String userId, String companyNature,
			String jobRank, String companyName, String positionName,
			String isDeleted) {
		this.moduleId = moduleId;
		this.userId = userId;
		this.companyNature = companyNature;
		this.jobRank = jobRank;
		this.companyName = companyName;
		this.positionName = positionName;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Jobinfomodule(int moduleId, String userId, String companyNature,
			String jobRank, String companyName, String positionName,
			String resume, String isDeleted) {
		this.moduleId = moduleId;
		this.userId = userId;
		this.companyNature = companyNature;
		this.jobRank = jobRank;
		this.companyName = companyName;
		this.positionName = positionName;
		this.resume = resume;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public int getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyNature() {
		return this.companyNature;
	}

	public void setCompanyNature(String companyNature) {
		this.companyNature = companyNature;
	}

	public String getJobRank() {
		return this.jobRank;
	}

	public void setJobRank(String jobRank) {
		this.jobRank = jobRank;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}