package com.cem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.UserDao;
import com.cem.pojo.User;
import com.cem.service.UserService;

/**
 * Created by RayHauton on 2017/1/25.
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao = null;

	@Override
	public void insertUser(User user) throws Exception {
		/*
		 * 设置审核，删除标志位
		 */
		user.setCheckOut("0");
		user.setIsDeleted("0");
		userDao.insertUser(user);
	}

	@Override
	public User findUserByUserId(long userId) throws Exception {
		return userDao.findUserByUserId(userId);
	}

	@Override
	public User findUserByStudNum(String studNum,boolean passed) throws Exception {
		return userDao.findUserByStudNum(studNum,passed);
	}

	@Override
	public User findUserByUsername(String username,boolean passed) throws Exception {
		return userDao.findUserByUsername(username,passed);
	}

	@Override
	public User findUserByMobile(String mobile,boolean passed) throws Exception {
		return userDao.findUserByMobile(mobile,passed);
	}

	@Override
	public User finduserByEmail(String email,boolean passed) throws Exception {
		return userDao.finduserByEmail(email,passed);
	}
}
