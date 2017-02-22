package com.cem.service;

import java.util.Map;

import com.cem.pojo.Recruitment;
import com.cem.queryVO.RecruitmentQueryVo;

public interface RecruitmentService {
	/*
	 * 发布招聘信息
	 */
	public void insertRecruitment(Recruitment recruitment) throws Exception;
	
	/*
	 * 查询招聘信息（带分页）
	 */
	public Map<String,Object> findAll(RecruitmentQueryVo queryVo) throws Exception;
}
