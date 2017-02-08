package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.UserDao;
import com.cem.pojo.User;

/**
 * Created by RayHauton on 2017/1/25.
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insertUser(User user) throws Exception {
		Session session = getSession();
		session.save(user);
	}

	@Override
	public User findUserByUserId(long userId) throws Exception {
		return null;
	}

	@Override
	public User findUserByStudNum(String studNum, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {// 如果查找已经通过审核的用户
			hql = "FROM User user WHERE user.studNumber=? and user.isDeleted=? and user.checkOut='1'";
		} else {
			hql = "FROM User user WHERE user.studNumber=? and user.isDeleted=?";
		}
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery(hql).setParameter(0, studNum).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUsername(String username, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {
			hql = "FROM User where username=? and isDeleted=? and checkOut='1'";
		} else {
			hql = "FROM User where username=? and isDeleted=?";
		}
		List<User> users = session.createQuery(hql).setParameter(0, username).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@Override
	public User findUserByMobile(String mobile, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {
			hql = "FROM User where mobile=? and isDeleted=? and checkOut='1'";
		} else {
			hql = "FROM User where mobile=? and isDeleted=?";
		}
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery(hql).setParameter(0, mobile).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@Override
	public User finduserByEmail(String email, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {
			hql = "FROM User where email=? and isDeleted=? and checkOut='1'";
		} else {
			hql = "FROM User where email=? and isDeleted=?";
		}
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery(hql).setParameter(0, email).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@Override
	public User findIfUserExist(String username, String mobile, String studNum, String email) throws Exception {
		User user = null;
		if ((user = findUserByMobile(mobile, false)) != null) {
		} else if ((user = findUserByUsername(username, false)) != null) {
		} else if ((user = finduserByEmail(email, false)) != null) {
		} else if ((user = findUserByStudNum(studNum, false)) != null) {
		} else {
		}
		return user;
	}

	@Override
	public void updateUser(User user) throws Exception {
		Session session = getSession();
		session.update(user);
	}

}
