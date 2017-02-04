package com.cem.daoImpl;

import com.cem.dao.UserDao;
import com.cem.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by RayHauton on 2017/1/25.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findUserByUserId(long userId) throws Exception {
        return null;
    }

    @Override
    public User findUserByStudNum(String studNum) throws Exception {
        Session session = getSession();
        String hql = "FROM User user WHERE user.studNumber=? and user.isDeleted=?";
        User user = (User) session.createQuery(hql).setParameter(0,studNum).setParameter(1,"0").uniqueResult();
        return user;
    }

    @Override
    public User findUserByUsername(String username) throws Exception {
        Session session = getSession();
        String hql = "FROM User where username=? and isDeleted=?";
        User user = (User) session.createQuery(hql).setParameter(0,username).setParameter(1,"0").uniqueResult();
        return user;
    }

    @Override
    public User findUserByMobile(String mobile) throws Exception {
        Session session = getSession();
        String hql = "FROM User where mobile=? and isDeleted=?";
        User user = (User) session.createQuery(hql).setParameter(0,mobile).setParameter(1,"0").uniqueResult();
        return user;
    }

    @Override
    public User finduserByEmail(String email) throws Exception {
        Session session = getSession();
        String hql = "FROM User where mail=? and isDeleted=?";
        User user = (User) session.createQuery(hql).setParameter(0,email).setParameter(1,"0").uniqueResult();
        return user;
    }

}
