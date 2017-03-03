package com.cem.customPojo;

import com.cem.pojo.User;

public class UserCustom extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8932533616438444556L;
	private String degreeId;
	private String majorId;
	private String degreeName;
	private String majorName;
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
}
