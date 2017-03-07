package com.cem.dao;

import java.util.List;

import com.cem.pojo.User;

/**
 * Created by RayHauton on 2017/1/25.
 */
public interface UserDao {

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
	public User findUserByStudNum(String userId, boolean passed) throws Exception;

	/*
	 * 根据用户名查找用户
	 */
	public User findUserByUsername(String username, boolean passed) throws Exception;

	/*
	 * 根据电话号码查询
	 */
	public User findUserByMobile(String mobile, boolean passed) throws Exception;

	/*
	 * 根据邮箱查找用户
	 */
	public User finduserByEmail(String email, boolean passed) throws Exception;

	/*
	 * 查找用户是否已经存在，用于用户注册不通过重新注册的时候 如果只是添加新纪录会导致数据库的唯一性破坏，所以要进行查询
	 * 存在就直接更新对应的记录，没有就添加新纪录
	 */
	public User findIfUserExist(String username, String mobile, String studNum, String email) throws Exception;

	/*
	 * 更新数据库记录
	 */
	public void updateUser(User user) throws Exception;
	
	public List<User> findUsersByTruename(String trueName,boolean passed,int pageSize);
	
	public List<User> findUserByEntranceDate(String entranceDate,boolean passed,int pageSize);
	
	public List<User> findUserByEntAndTrueName(String entranceDate,String trueName,boolean passed,int pageSize);
}
