package com.cem.serviceImpl;

import java.util.List;

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
	public User findUserByStudNum(String studNum, boolean passed) throws Exception {
		return userDao.findUserByStudNum(studNum, passed);
	}

	@Override
	public User findUserByUsername(String username, boolean passed) throws Exception {
		return userDao.findUserByUsername(username, passed);
	}

	@Override
	public User findUserByMobile(String mobile, boolean passed) throws Exception {
		return userDao.findUserByMobile(mobile, passed);
	}

	@Override
	public User finduserByEmail(String email, boolean passed) throws Exception {
		return userDao.finduserByEmail(email, passed);
	}

	@Override
	public User findIfUserExist(String username, String mobile, String studNum, String email) throws Exception {
		return userDao.findIfUserExist(username, mobile, studNum, email);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}


	@Override
	public List<User> findUsersByTrueName(String trueName, boolean passed, int pageSize) throws Exception {
		return userDao.findUsersByTruename(trueName, passed, pageSize);
	}

	@Override
	public List<User> findUsersByEntranceDate(String entranceDate, boolean passed, int pagesize) throws Exception {
		return userDao.findUserByEntranceDate(entranceDate, passed, pagesize);
	}

	@Override
	public List<User> finUserByEnAndTrueName(String entranceDate, String trueName, boolean passed, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserByEntAndTrueName(entranceDate, trueName, passed, pageSize);
	}

}
