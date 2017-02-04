package com.cem.serviceImpl;

import com.cem.dao.UserDao;
import com.cem.pojo.User;
import com.cem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RayHauton on 2017/1/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao = null;

    @Override
    public User findUserByUserId(long userId) throws Exception {
        return userDao.findUserByUserId(userId);
    }

    @Override
    public User findUserByStudNum(String studNum) throws Exception {
        return userDao.findUserByStudNum(studNum);
    }

    @Override
    public User findUserByUsername(String username) throws Exception {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findUserByMobile(String mobile) throws Exception {
        return userDao.findUserByMobile(mobile);
    }

    @Override
    public User finduserByEmail(String email) throws Exception {
        return userDao.finduserByEmail(email);
    }
}
