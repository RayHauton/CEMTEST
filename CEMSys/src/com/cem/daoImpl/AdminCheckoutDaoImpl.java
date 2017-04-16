package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.AdminCheckoutDao;
import com.cem.pojo.User;

@Repository
public class AdminCheckoutDaoImpl implements AdminCheckoutDao{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUncheckoutUser() throws Exception {
		Session session = getSession();
		String hql = "from User u where u.checkOut = '0'";
		Query query = session.createQuery(hql);
		List<User> queryList = (List<User>) query.list();
		return queryList;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getStudentByStuName(String StuName) throws Exception {
		Session session = getSession();
		String hql = "select s.id from StudentList s where s.StuName='"+StuName+"'";
		Query query = session.createSQLQuery(hql);
		List<Integer> queryList = (List<Integer>) query.list();
		return queryList;
	}


	@Override
	public int getStudentByStuId(String StuId) throws Exception {
		Session session = getSession();
		String hql = "select s.id from StudentList s where s.StuId='"+StuId+"'";
		Query query = session.createSQLQuery(hql);
		List<Integer> ids =  (List<Integer>) query.list();
		if(!ids.isEmpty()) return ids.get(0);
		return 0;
	}

	@Override
	public String getStudentById(int Id) throws Exception {
		Session session = getSession();
		String hql = "select s.stuId from StudentList s where s.id='"+Id+"'";
		Query query = session.createSQLQuery(hql);
		String stuId = (String) query.uniqueResult();
		return stuId;
	}

	@Override
	public List<String> getEntranceDateBystuName(String stuName) throws Exception {
		Session session = getSession();
		String hql = "select s.entranceDate from StudentList s where s.stuName='"+stuName+"'";
		Query query = session.createSQLQuery(hql);
		List<String> entranceDate = (List<String>) query.list();
		return entranceDate;
	}


	@Override
	public String getEntranceDateByStuid(int Id) throws Exception {
		Session session = getSession();
		String hql = "select s.entranceDate from StudentList s where s.id='"+Id+"'";
		Query query = session.createSQLQuery(hql);
		String entranceDate = (String) query.uniqueResult();
		return entranceDate;
	}


	@Override
	public void Audit(String flag,String username) throws Exception {
		Session session = getSession();
		String hql = "update User u set u.checkOut = '"+ flag +"' where u.username='"+username+"'";
		session.createSQLQuery(hql).executeUpdate();
	}


	@Override
	public String getEmailByUsername(String username) throws Exception {
		Session session = getSession();
		String hql = "select u.email from User u where u.username='"+username+"'";
		Query query = session.createSQLQuery(hql);
		String email = (String) query.uniqueResult();
		return email;
	}


	@Override
	public List<String> getUseridByTruename(String truename) throws Exception {
		Session session = getSession();
		String hql = "select s.stuId from StudentList s where s.stuName='"+truename+"'";
		Query query = session.createQuery(hql);
		List<String> stuIdList = (List<String>) query.list();
		return stuIdList;
	}

}
