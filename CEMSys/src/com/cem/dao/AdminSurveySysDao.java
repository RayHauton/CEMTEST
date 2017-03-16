package com.cem.dao;

import java.util.List;

import com.cem.pojo.User;
import com.cem.queryVO.AdminSurveyQueryVo;


public interface AdminSurveySysDao {
	
	/**
	 * 关联Selfabilityquality和Majorabilitycultivationquality，获取满足条件的userId
	 * @param adminSurveyQueryVo
	 * @return
	 */
	public List<Integer> searchSMCondition(AdminSurveyQueryVo adminSurveyQueryVo);
	
	
	
	/**
	 * 根据userId查询到该用户对应的信息
	 * @param userId
	 * @return
	 */
	public User searchUserByUserId(int userId);
	
	

	/**
	 * 查找出User表中所有的用户ID号
	 * @return
	 * @throws Exception
	 */
	public String[] searchAllUser()throws Exception;
	
}

