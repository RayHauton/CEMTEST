package com.cem.dao;

import java.util.List;

import com.cem.customPojo.UserBaseInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cem.pojo.User;
import com.cem.queryVO.UserManageVo;

/**
 * Created by RayHauton on 2017/1/25.
 */
public interface UserDao {
	
	/**
	 * 找到用户密码
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String findPassword(int userId) throws Exception;
	/**
	 * 更换密码
	 * @param userId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean alterPassword(int userId,String password) throws Exception;
	
	/*
	 * 根据班号以及姓名查询同班的人
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
	public User findUserByStudNum(String studNumber, boolean passed) throws Exception;

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
	
	public List<User> findUsersWithOut()throws Exception;

	/*
	 * 更新数据库记录
	 */
	public boolean updateUser(User user) throws Exception;
	
	
//	public void deleteUser(User user) throws Exception;

	/*
	 * 被usermanage使用
	 */
	public List<Object> findUsersFromUserManage(UserManageVo userManageVo) throws Exception;
	
	public List<Object> finddUsersFromUserManageWithOut(String passed,int pageSize,int pageIndex) throws Exception;
	
	public int countUsers(UserManageVo userManageVo)throws Exception;
	
	public int countUsersWithOut(String passed)throws Exception;
	/*下载用户信息相关*/
	
	public void dataToExcel(List<User> userList,HttpServletRequest request) throws Exception; 
	
	public void download(HttpServletRequest request,HttpServletResponse response)throws Exception;
	
	
	
}
