package com.cem.dao;

import java.util.List;

import com.cem.pojo.Recruitment;


/*
 * 招聘信息dao
 */
public interface RecruitmentDao {
	/*
	 * 新增招聘信息
	 */
	public void insertRecruitment(Recruitment recruitment) throws Exception;
	
	/*
	 * 查询招聘信息(带分页)
	 */
	public List<Recruitment> findAll(int pageIndex,int pageSize) throws Exception;
}
