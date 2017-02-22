package com.cem.dao;

import java.util.Map;

import com.cem.pojo.Recruitment;
import com.cem.queryVO.RecruitmentQueryVo;

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
	public Map<String,Object> findAll(RecruitmentQueryVo queryVo) throws Exception;
}
