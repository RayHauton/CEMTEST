package com.cem.dao;

import java.util.List;

import com.cem.pojo.User;

public interface AdminCheckoutDao {

	/**
	 * 获取未审核通过的用户
	 * @return
	 * @throws Exception
	 */
	public List<User> getUncheckoutUser() throws Exception;
	
	/**
	 * 通过注册信息中的学生名字在学生名单中获得对应的ID号，存在同名同姓的情况，故用List
	 * @param StuName
	 * @return
	 * @throws Exception
	 */
	public List<Integer> getStudentByStuName(String StuName) throws Exception;
	
	/**
	 * 通过注册信息的学号获得学生在学生名单对应的ID号 
	 * @param StuId
	 * @return
	 * @throws Exception
	 */
	public int getStudentByStuId(String StuId)throws Exception; 
	
	/**
	 * 通过Id获取学生名单中的学生学号
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	public String getStudentById(int Id)throws Exception;
	
	/**
	 * 通过注册信息的学生名字获得学生的入学时间
	 * @param stuName
	 * @return
	 * @throws Exception
	 */
	public List<String> getEntranceDateBystuName(String stuName)throws Exception;
	
	/**
	 * 通过注册信息的学号获得学生的入学时间
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	public String getEntranceDateByStuid(int Id)throws Exception;
	
	/**
	 * 通过用户名审核用户是否通过
	 * @param flag
	 * @param username
	 * @throws Exception
	 */
	public void Audit(String flag,String username) throws Exception;
	
	/**
	 * 根据用户名获取用户信息
	 * @return
	 * @throws Exception
	 */
	public String getEmailByUsername(String username) throws Exception;
	
	public List<String> getUseridByTruename(String truename) throws Exception;
	
}
