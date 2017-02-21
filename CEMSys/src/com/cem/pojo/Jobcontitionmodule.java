package com.cem.pojo;

/**
 * Jobcontitionmodule entity. @author MyEclipse Persistence Tools
 */

public class Jobcontitionmodule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6551063923964979848L;
	private Long conditionId;
	private Long userId;
	private Integer yearsToBusinessSelf;
	private String honorName;
	private Integer firstPromote;
	private String satisLevelOfBusinessSelf;
	private String reasonOfNotStatis;
	private Integer transferJobCount;
	private String satisLevelOfCurrJob;
	private String income;
	private Short honorLevel;
	private Short companyExamine;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public Jobcontitionmodule() {
	}

	/** minimal constructor */
	public Jobcontitionmodule(Long conditionId, Long userId,
			Integer yearsToBusinessSelf, Integer firstPromote,
			String satisLevelOfBusinessSelf, Integer transferJobCount,
			String satisLevelOfCurrJob, String income, Short honorLevel,
			Short companyExamine, String isDeleted) {
		this.conditionId = conditionId;
		this.userId = userId;
		this.yearsToBusinessSelf = yearsToBusinessSelf;
		this.firstPromote = firstPromote;
		this.satisLevelOfBusinessSelf = satisLevelOfBusinessSelf;
		this.transferJobCount = transferJobCount;
		this.satisLevelOfCurrJob = satisLevelOfCurrJob;
		this.income = income;
		this.honorLevel = honorLevel;
		this.companyExamine = companyExamine;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Jobcontitionmodule(Long conditionId, Long userId,
			Integer yearsToBusinessSelf, String honorName,
			Integer firstPromote, String satisLevelOfBusinessSelf,
			String reasonOfNotStatis, Integer transferJobCount,
			String satisLevelOfCurrJob, String income, Short honorLevel,
			Short companyExamine, String isDeleted) {
		this.conditionId = conditionId;
		this.userId = userId;
		this.yearsToBusinessSelf = yearsToBusinessSelf;
		this.honorName = honorName;
		this.firstPromote = firstPromote;
		this.satisLevelOfBusinessSelf = satisLevelOfBusinessSelf;
		this.reasonOfNotStatis = reasonOfNotStatis;
		this.transferJobCount = transferJobCount;
		this.satisLevelOfCurrJob = satisLevelOfCurrJob;
		this.income = income;
		this.honorLevel = honorLevel;
		this.companyExamine = companyExamine;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public Long getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getYearsToBusinessSelf() {
		return this.yearsToBusinessSelf;
	}

	public void setYearsToBusinessSelf(Integer yearsToBusinessSelf) {
		this.yearsToBusinessSelf = yearsToBusinessSelf;
	}

	public String getHonorName() {
		return this.honorName;
	}

	public void setHonorName(String honorName) {
		this.honorName = honorName;
	}

	public Integer getFirstPromote() {
		return this.firstPromote;
	}

	public void setFirstPromote(Integer firstPromote) {
		this.firstPromote = firstPromote;
	}

	public String getSatisLevelOfBusinessSelf() {
		return this.satisLevelOfBusinessSelf;
	}

	public void setSatisLevelOfBusinessSelf(String satisLevelOfBusinessSelf) {
		this.satisLevelOfBusinessSelf = satisLevelOfBusinessSelf;
	}

	public String getReasonOfNotStatis() {
		return this.reasonOfNotStatis;
	}

	public void setReasonOfNotStatis(String reasonOfNotStatis) {
		this.reasonOfNotStatis = reasonOfNotStatis;
	}

	public Integer getTransferJobCount() {
		return this.transferJobCount;
	}

	public void setTransferJobCount(Integer transferJobCount) {
		this.transferJobCount = transferJobCount;
	}

	public String getSatisLevelOfCurrJob() {
		return this.satisLevelOfCurrJob;
	}

	public void setSatisLevelOfCurrJob(String satisLevelOfCurrJob) {
		this.satisLevelOfCurrJob = satisLevelOfCurrJob;
	}

	public String getIncome() {
		return this.income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public Short getHonorLevel() {
		return this.honorLevel;
	}

	public void setHonorLevel(Short honorLevel) {
		this.honorLevel = honorLevel;
	}

	public Short getCompanyExamine() {
		return this.companyExamine;
	}

	public void setCompanyExamine(Short companyExamine) {
		this.companyExamine = companyExamine;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}