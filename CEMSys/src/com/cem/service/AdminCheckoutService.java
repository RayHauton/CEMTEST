package com.cem.service;

import java.util.List;

import com.cem.pojo.User;

public interface AdminCheckoutService {

	/**
	 * 获取未审核通过的用户
	 * @return
	 * @throws Exception
	 */
	public List<User> getUncheckoutUser() throws Exception;
	
	/**
	 * 将未审核的用户与数据库中学生名单进行匹配
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<String> checkouting(User user)throws Exception;
	
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
}
