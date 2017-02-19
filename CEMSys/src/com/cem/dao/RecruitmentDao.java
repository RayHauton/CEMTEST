package com.cem.dao;

import com.cem.pojo.Recruitment;

/*
 * 招聘信息dao
 */
public interface RecruitmentDao {
	/*
	 * 新增招聘信息
	 */
	public void insertRecruitment(Recruitment recruitment) throws Exception;
}
