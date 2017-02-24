package com.cem.pojo;
// Generated 2017-2-24 22:31:30 by Hibernate Tools 4.0.1.Final

/**
 * Jobcontitionmodule generated by hbm2java
 */
public class Jobcontitionmodule implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7732504454608106445L;
	private int conditionId;
	private int userId;
	private int yearsToBusinessSelf;
	private String honorName;
	private int firstPromote;
	private String satisLevelOfBusinessSelf;
	private String reasonOfNotStatis;
	private int transferJobCount;
	private String satisLevelOfCurrJob;
	private String income;
	private short honorLevel;
	private short companyExamine;
	private String isDeleted;

	public Jobcontitionmodule() {
	}

	public Jobcontitionmodule(int conditionId, int userId, int yearsToBusinessSelf, int firstPromote,
			String satisLevelOfBusinessSelf, int transferJobCount, String satisLevelOfCurrJob, String income,
			short honorLevel, short companyExamine, String isDeleted) {
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

	public Jobcontitionmodule(int conditionId, int userId, int yearsToBusinessSelf, String honorName, int firstPromote,
			String satisLevelOfBusinessSelf, String reasonOfNotStatis, int transferJobCount, String satisLevelOfCurrJob,
			String income, short honorLevel, short companyExamine, String isDeleted) {
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

	public int getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getYearsToBusinessSelf() {
		return this.yearsToBusinessSelf;
	}

	public void setYearsToBusinessSelf(int yearsToBusinessSelf) {
		this.yearsToBusinessSelf = yearsToBusinessSelf;
	}

	public String getHonorName() {
		return this.honorName;
	}

	public void setHonorName(String honorName) {
		this.honorName = honorName;
	}

	public int getFirstPromote() {
		return this.firstPromote;
	}

	public void setFirstPromote(int firstPromote) {
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

	public int getTransferJobCount() {
		return this.transferJobCount;
	}

	public void setTransferJobCount(int transferJobCount) {
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

	public short getHonorLevel() {
		return this.honorLevel;
	}

	public void setHonorLevel(short honorLevel) {
		this.honorLevel = honorLevel;
	}

	public short getCompanyExamine() {
		return this.companyExamine;
	}

	public void setCompanyExamine(short companyExamine) {
		this.companyExamine = companyExamine;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}
