package com.cem.queryVO;

public class UserManageVo {
	private String sex;
	private String birth;
	private String email;
	private String mobile;
	private String address;
	private String graduateDate;
	private String username;
	private String studNumber;
	private String truename;
	private String entranceDate;
	private String majorId;
	private String degreeId;
	private String audit;
	private String accessMode;// 访问的方式
	private String pageSize;// 每一页可容纳最大记录条数
	private String pageIndex;// 当前页面数
	private String recordCount;// 总记录条数
	private int pageCount;// 总共的页数

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccessMode() {
		return accessMode;
	}

	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
	}

	public int getPageCount() {
		return pageCount;
	}
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getGraduateDate() {
		return graduateDate;
	}
	
	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getAudit() {
		return audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
	}

	public String getStudNumber() {
		return studNumber;
	}

	public void setStudNumber(String studNumber) {
		this.studNumber = studNumber;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

}
