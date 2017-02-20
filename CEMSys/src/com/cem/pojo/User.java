package com.cem.pojo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5370282005346457795L;
	private Long userId;
	private String username;
	private String truename;
	private String password;
	private String sex;
	private String studNumber;
	private String birth;
	private String mobile;
	private String email;
	private String address;
	private String entranceDate;
	private String graduateDate;
	private String schoolExperienceId;
	private String checkOut;
	private String bbsrank;
	private String role;
	private String isDeleted;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Long userId, String username, String truename,
			String password, String sex, String studNumber, String birth,
			String mobile, String email, String address, String entranceDate,
			String graduateDate, String schoolExperienceId, String checkOut,
			String isDeleted) {
		this.userId = userId;
		this.username = username;
		this.truename = truename;
		this.password = password;
		this.sex = sex;
		this.studNumber = studNumber;
		this.birth = birth;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.entranceDate = entranceDate;
		this.graduateDate = graduateDate;
		this.schoolExperienceId = schoolExperienceId;
		this.checkOut = checkOut;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public User(Long userId, String username, String truename,
			String password, String sex, String studNumber, String birth,
			String mobile, String email, String address, String entranceDate,
			String graduateDate, String schoolExperienceId, String checkOut,
			String bbsrank, String role, String isDeleted) {
		this.userId = userId;
		this.username = username;
		this.truename = truename;
		this.password = password;
		this.sex = sex;
		this.studNumber = studNumber;
		this.birth = birth;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.entranceDate = entranceDate;
		this.graduateDate = graduateDate;
		this.schoolExperienceId = schoolExperienceId;
		this.checkOut = checkOut;
		this.bbsrank = bbsrank;
		this.role = role;
		this.isDeleted = isDeleted;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSchoolExperienceId() {
		return this.schoolExperienceId;
	}

	public void setSchoolExperienceId(String schoolExperienceId) {
		this.schoolExperienceId = schoolExperienceId;
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