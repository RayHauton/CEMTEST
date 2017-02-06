package com.cem.service;

import com.cem.pojo.User;

/**
 * Created by RayHauton on 2017/1/25.
 */
public interface UserService {
	/*
	 * 添加用户信息
	 */
	public void insertUser(User user) throws Exception;

	/*
	 * 根据用户Id查找用户（一般不会用）
	 */
	public User findUserByUserId(long userId) throws Exception;

	/*
	 * 根据学号查找用户
	 */
	public User findUserByStudNum(String userId,boolean passed) throws Exception;

	/*
	 * 根据用户名查找用户
	 */
	public User findUserByUsername(String username,boolean passed) throws Exception;

	/*
	 * 根据电话号码查询
	 */
	public User findUserByMobile(String mobile,boolean passed) throws Exception;

	/*
	 * 根据邮箱查找用户
	 */
	public User finduserByEmail(String email,boolean passed) throws Exception;
}
