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
		User user = (User) session.createQuery(hql).setParameter(0, studNum).setParameter(1, "0").uniqueResult();
		return user;
	}

	@Override
	public User findUserByUsername(String username, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {
			hql = "FROM User where username=? and isDeleted=? and checkOut='1'";
		} else {
			hql = "FROM User where username=? and isDeleted=?";
		}
		User user = (User) session.createQuery(hql).setParameter(0, username).setParameter(1, "0").uniqueResult();
		return user;
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
		User user = (User) session.createQuery(hql).setParameter(0, mobile).setParameter(1, "0").uniqueResult();
		return user;
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
		User user = (User) session.createQuery(hql).setParameter(0, email).setParameter(1, "0").uniqueResult();
		return user;
	}

}
