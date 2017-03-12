package com.cem.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;


public interface AdminSurveySysService {

	/**
	 * 关联Selfabilityquality和Majorabilitycultivationquality，获取满足条件的userId
	 * @param titleNum
	 * @param scoreNum
	 * @return
	 */
	public List<Integer> searchSMCondition(String[] titleNum,String[] scoreNum);
	
	/**
	 * 根据userId查询到该用户对应的信息
	 * @param list
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
	
	public String[] searchAllUser()throws Exception;
}
