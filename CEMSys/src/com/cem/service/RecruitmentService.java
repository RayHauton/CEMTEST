package com.cem.service;

import java.util.List;

import com.cem.pojo.Recruitment;

public interface RecruitmentService {
	/*
	 * 发布招聘信息
	 */
	public void insertRecruitment(Recruitment recruitment) throws Exception;
	
	/*
	 * 查询招聘信息（带分页）
	 */
	public List<Recruitment> findAll(int pageIndex,int pageSize) throws Exception;
}
