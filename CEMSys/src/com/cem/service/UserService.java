package com.cem.service;

import java.util.List;
import java.util.Map;

import com.cem.customPojo.UserBaseInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cem.pojo.User;
import com.cem.queryVO.UserManageVo;

/**
 * Created by RayHauton on 2017/1/25.
 */
public interface UserService {
	/**
	 *查找用户的密码 
	 * @param userId
	 * @return String
	 * @throws Exception
	 */
	public String findPassword(int userId) throws Exception;
	
	/**
	 * 
	 * @param userId 用户ID
	 * @param password 密码
	 * @return true or false
	 * @throws Exception
	 */
	public boolean alterPassword(int userId,String password) throws Exception;
	
	/**
	 * 
	 * @param classNo 班级号码
	 * @param truename 真实姓名
	 * @throws Exception
	 */
	public List<UserBaseInfo> findClassMateByClasNo(String truename,String classNo) throws Exception;
	
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
	
	/*删除用户*/
	public boolean deleteUser(User user) throws Exception;
	
	
	public List<User> findUserWithOut() throws Exception;
	/*
	 * userManage使用
	 */
	public Map<String, Object> findUsersFromUserManage(UserManageVo userManageVo)throws Exception;	
	
	public Map<String, Object> findUsersFromUserManageWithOut(UserManageVo userManageVo) throws Exception;
	
	public void checkUserStates(String[] studNumberArr,String[] auditArr)throws Exception;
	
	public void downloadUsers(List<User> uList,HttpServletRequest request,HttpServletResponse response) throws Exception;
	
}
