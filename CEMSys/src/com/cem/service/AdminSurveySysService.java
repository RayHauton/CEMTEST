package com.cem.service;

import java.util.List;


import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;
import com.cem.queryVO.AdminSurveyQueryVo;


public interface AdminSurveySysService {

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
	 * 将所查询到的信息写到Excel中
	 * @param userList
	 * @param sList
	 * @param mList
	 * @throws Exception
	 */
	public void dataToExcel(List<User> userList,List<Selfabilityquality> sList,List<Majorabilitycultivationquality> mList) throws Exception;
	
	/**
	 * 下载生成的Excel文件并删除本地生成的临时文件
	 * @throws Exception
	 */
	public void download()throws Exception;
	
	/**
	 * 查找出User表中所有的用户ID号
	 * @return
	 * @throws Exception
	 */
	public String[] searchAllUser()throws Exception;
}
