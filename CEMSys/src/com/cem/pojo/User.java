package com.cem.pojo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4173699195242720918L;
	private Integer userId;
	private String username;
	private String truename;
	private String password;
	private String sex;
	private String studNumber;
	private String birth;
	private String mobile;
	private String mail;
	private String address;
	private String entranceDate;
	private String graduateDate;
	private String education;
	private String schoolExperience;
	private String checkOut;
	private String bbsrank;
	private String role;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public User(Integer userId, String username, String truename,
			String password, String sex, String studNumber, String birth,
			String mobile, String mail, String address, String entranceDate,
			String graduateDate, String education, String schoolExperience,
			String checkOut, String bbsrank, String role, String isDeleted) {
		this.userId = userId;
		this.username = username;
		this.truename = truename;
		this.password = password;
		this.sex = sex;
		this.studNumber = studNumber;
		this.birth = birth;
		this.mobile = mobile;
		this.mail = mail;
		this.address = address;
		this.entranceDate = entranceDate;
		this.graduateDate = graduateDate;
		this.education = education;
		this.schoolExperience = schoolExperience;
		this.checkOut = checkOut;
		this.bbsrank = bbsrank;
		this.role = role;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStudNumber() {
		return this.studNumber;
	}

	public void setStudNumber(String studNumber) {
		this.studNumber = studNumber;
	}

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntranceDate() {
		return this.entranceDate;
	}

	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}

	public String getGraduateDate() {
		return this.graduateDate;
	}

	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchoolExperience() {
		return this.schoolExperience;
	}

	public void setSchoolExperience(String schoolExperience) {
		this.schoolExperience = schoolExperience;
	}

	public String getCheckOut() {
		return this.checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getBbsrank() {
		return this.bbsrank;
	}

	public void setBbsrank(String bbsrank) {
		this.bbsrank = bbsrank;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}