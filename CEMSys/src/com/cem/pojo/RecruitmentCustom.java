package com.cem.pojo;
/*
 * Recruitment扩展类
 */
public class RecruitmentCustom extends Recruitment {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5868333978213927610L;

	@Override
	public String getTruename() {
		return truename;
	}

	@Override
	public void setTruename(String truename) {
		this.truename = truename;
	}

	private String truename;
}
