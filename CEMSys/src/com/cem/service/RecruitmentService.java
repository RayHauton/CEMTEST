package com.cem.service;

import com.cem.pojo.Recruitment;

public interface RecruitmentService {
	/*
	 * 发布招聘信息
	 */
	public void insertRecruitment(Recruitment recruitment) throws Exception;
}
