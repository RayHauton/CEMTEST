package com.cem.daoImpl;

import java.util.List;

import org.aspectj.weaver.ast.And;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.UserDao;
import com.cem.pojo.User;
import com.cem.queryVO.UserManageVo;

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
	public boolean updateUser(User user) throws Exception {
		Session session = getSession();
		session.merge(user);
		session.flush();
		return true;
	}

	@Override
	public List<Object> findUsersFromUserManage(UserManageVo userManageVo) throws Exception {
		System.out.println("dao层开始");
		Session session = getSession();
		String studNumber = userManageVo.getStudNumber();
		String truename = userManageVo.getTruename();
		String entranceDate = userManageVo.getEntranceDate();
		String majorId = userManageVo.getMajorId();
		String degreeId = userManageVo.getDegreeId();
		System.out.println(studNumber);
		System.out.println(truename);
		System.out.println(entranceDate);
		System.out.println(majorId);
		System.out.println(degreeId);
		String passed = userManageVo.getAudit();

		if ((studNumber == null | "".equals(studNumber)) && (truename == null | "".equals(truename))
				&& (entranceDate == null | "".equals(entranceDate)) && (majorId == null | "".equals(majorId))
				&& (degreeId == null | "".equals(degreeId))) {
			System.out.println("错误查询");
			return null;
		}
		StringBuilder hql = new StringBuilder(
				"select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate from User u join SchoolExperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) where u.isDeleted  = '0' ");
		if ("0".equals(passed))
			hql.append("And u.checkOut='0' ");
		else if ("1".equals(passed)) {
			hql.append("And u.checkOut='1' ");
		}
		if (studNumber != null && !("".equals(studNumber)))
			hql.append("And u.studNumber= " + studNumber);
		else {
			if (truename != null && !("".equals(truename))) {
				hql.append("And u.truename = " + truename);
			}
			if (entranceDate != null && !("".equals(entranceDate))) {
				hql.append("And u.entranceDate = " + entranceDate);
			}
			if (majorId != null && !("".equals(majorId)))
				hql.append("And s.majorId = '" + majorId + "'");
			if (degreeId != null && !("".equals(degreeId)))
				hql.append("And s.degreeId  = '" + degreeId + "'");
		}
		System.out.println(hql.toString());
		return session.createSQLQuery(hql.toString()).setFirstResult(0).list();

	}

	@Override
	public List<Object> finddUsersFromUserManageWithOut(String passed) throws Exception {
		Session session = getSession();
		String hql = null;
		System.out.println(passed);
		if ("1".equals(passed))
			hql = "select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate "
					+ "from User u join SchoolExperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) "
					+ "where u.isDeleted  = '0' and u.checkOut = '1' ";
		else if ("3".equals(passed)) {
			hql = "select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate "
					+ "from User u join SchoolExperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) "
					+ "where u.isDeleted  = '0' ";
		} else if ("0".equals(passed)) {
			hql = "select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate "
					+ "from User u join SchoolExperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) "
					+ "where u.isDeleted  = '0' and u.checkOut = '0' ";
		}
		return session.createSQLQuery(hql).setFirstResult(0).list();
	}

}
