package com.cem.pojo;
// Generated 2017-2-24 22:31:30 by Hibernate Tools 4.0.1.Final

/**
 * Jobinfomodule generated by hbm2java
 */
public class Jobinfomodule implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7354844074864643728L;
	private int moduleId;
	private int userId;
	private String companyNature;
	private String jobRank;
	private String companyName;
	private String positionName;
	private String resume;
	private String isDeleted;

	public Jobinfomodule() {
	}

	public Jobinfomodule(String companyName) {
		this.companyName = companyName;
	}

	public Jobinfomodule(int moduleId, int userId, String companyNature, String jobRank, String companyName,
			String positionName, String isDeleted) {
		this.moduleId = moduleId;
		this.userId = userId;
		this.companyNature = companyNature;
		this.jobRank = jobRank;
		this.companyName = companyName;
		this.positionName = positionName;
		this.isDeleted = isDeleted;
	}

	public Jobinfomodule(int moduleId, int userId, String companyNature, String jobRank, String companyName,
			String positionName, String resume, String isDeleted) {
		this.moduleId = moduleId;
		this.userId = userId;
		this.companyNature = companyNature;
		this.jobRank = jobRank;
		this.companyName = companyName;
		this.positionName = positionName;
		this.resume = resume;
		this.isDeleted = isDeleted;
	}

	public int getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
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
