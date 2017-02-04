package com.cem.service;

import com.cem.pojo.User;

/**
 * Created by RayHauton on 2017/1/25.
 */
public interface UserService {
    /*
 根据用户Id查找用户（一般不会用）
  */
    public User findUserByUserId(long userId) throws Exception;

    /*
    根据学号查找用户
     */
    public User findUserByStudNum(String userId) throws Exception;
    /*
    根据用户名查找用户
     */
    public User findUserByUsername(String username) throws Exception;

    /*
    根据电话号码查询
     */
    public User findUserByMobile(String mobile) throws Exception;

    /*
    根据邮箱查找用户
     */
    public User finduserByEmail(String email) throws Exception;
}
