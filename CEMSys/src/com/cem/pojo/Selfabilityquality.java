package com.cem.pojo;

/**
 * Selfabilityquality entity. @author MyEclipse Persistence Tools
 */

public class Selfabilityquality implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2071806941358862424L;
	private Long userId;
	private Short gumptionAndAchvConscious;
	private Short companyCooperation;
	private Short professionalism;
	private Short majorBaseKnowledge;
	private Short knowledgeWidth;
	private Short foreignLanguage;
	private Short acquireAndApplyKnowledge;
	private Short selfDealProblem;
	private Short practiceAndHandsOn;
	private Short motivationAbility;
	private Short communicationAndOrganizeAbility;
	private Short wordsExpression;
	private Short psychologyBearAndAntiFrustration;
	private String isDelete;

	// Constructors

	/** default constructor */
	public Selfabilityquality() {
	}

	/** full constructor */
	public Selfabilityquality(Long userId, Short gumptionAndAchvConscious,
			Short companyCooperation, Short professionalism,
			Short majorBaseKnowledge, Short knowledgeWidth,
			Short foreignLanguage, Short acquireAndApplyKnowledge,
			Short selfDealProblem, Short practiceAndHandsOn,
			Short motivationAbility, Short communicationAndOrganizeAbility,
			Short wordsExpression, Short psychologyBearAndAntiFrustration) {
		this.userId = userId;
		this.gumptionAndAchvConscious = gumptionAndAchvConscious;
		this.companyCooperation = companyCooperation;
		this.professionalism = professionalism;
		this.majorBaseKnowledge = majorBaseKnowledge;
		this.knowledgeWidth = knowledgeWidth;
		this.foreignLanguage = foreignLanguage;
		this.acquireAndApplyKnowledge = acquireAndApplyKnowledge;
		this.selfDealProblem = selfDealProblem;
		this.practiceAndHandsOn = practiceAndHandsOn;
		this.motivationAbility = motivationAbility;
		this.communicationAndOrganizeAbility = communicationAndOrganizeAbility;
		this.wordsExpression = wordsExpression;
		this.psychologyBearAndAntiFrustration = psychologyBearAndAntiFrustration;
	}

	// Property accessors

	@Override
	public String toString() {
		return  gumptionAndAchvConscious
				+ "," + companyCooperation + "," + professionalism
				+ "," + majorBaseKnowledge + "," + knowledgeWidth
				+ "," + foreignLanguage + "," + acquireAndApplyKnowledge
				+ "," + selfDealProblem + "," + practiceAndHandsOn
				+ "," + motivationAbility + ","
				+ communicationAndOrganizeAbility + "," + wordsExpression
				+ "," + psychologyBearAndAntiFrustration;
	}
	
	public Long getUserId() {
		return this.userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Short getGumptionAndAchvConscious() {
		return this.gumptionAndAchvConscious;
	}

	public void setGumptionAndAchvConscious(Short gumptionAndAchvConscious) {
		this.gumptionAndAchvConscious = gumptionAndAchvConscious;
	}

	public Short getCompanyCooperation() {
		return this.companyCooperation;
	}

	public void setCompanyCooperation(Short companyCooperation) {
		this.companyCooperation = companyCooperation;
	}

	public Short getProfessionalism() {
		return this.professionalism;
	}

	public void setProfessionalism(Short professionalism) {
		this.professionalism = professionalism;
	}

	public Short getMajorBaseKnowledge() {
		return this.majorBaseKnowledge;
	}

	public void setMajorBaseKnowledge(Short majorBaseKnowledge) {
		this.majorBaseKnowledge = majorBaseKnowledge;
	}

	public Short getKnowledgeWidth() {
		return this.knowledgeWidth;
	}

	public void setKnowledgeWidth(Short knowledgeWidth) {
		this.knowledgeWidth = knowledgeWidth;
	}

	public Short getForeignLanguage() {
		return this.foreignLanguage;
	}

	public void setForeignLanguage(Short foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public Short getAcquireAndApplyKnowledge() {
		return this.acquireAndApplyKnowledge;
	}

	public void setAcquireAndApplyKnowledge(Short acquireAndApplyKnowledge) {
		this.acquireAndApplyKnowledge = acquireAndApplyKnowledge;
	}

	public Short getSelfDealProblem() {
		return this.selfDealProblem;
	}

	public void setSelfDealProblem(Short selfDealProblem) {
		this.selfDealProblem = selfDealProblem;
	}

	public Short getPracticeAndHandsOn() {
		return this.practiceAndHandsOn;
	}

	public void setPracticeAndHandsOn(Short practiceAndHandsOn) {
		this.practiceAndHandsOn = practiceAndHandsOn;
	}

	public Short getMotivationAbility() {
		return this.motivationAbility;
	}

	public void setMotivationAbility(Short motivationAbility) {
		this.motivationAbility = motivationAbility;
	}

	public Short getCommunicationAndOrganizeAbility() {
		return this.communicationAndOrganizeAbility;
	}

	public void setCommunicationAndOrganizeAbility(
			Short communicationAndOrganizeAbility) {
		this.communicationAndOrganizeAbility = communicationAndOrganizeAbility;
	}

	public Short getWordsExpression() {
		return this.wordsExpression;
	}

	public void setWordsExpression(Short wordsExpression) {
		this.wordsExpression = wordsExpression;
	}

	public Short getPsychologyBearAndAntiFrustration() {
		return this.psychologyBearAndAntiFrustration;
	}

	public void setPsychologyBearAndAntiFrustration(
			Short psychologyBearAndAntiFrustration) {
		this.psychologyBearAndAntiFrustration = psychologyBearAndAntiFrustration;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	

}