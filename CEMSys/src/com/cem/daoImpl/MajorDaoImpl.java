package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.MajorDao;
import com.cem.pojo.Major;
import com.cem.util.GenerateHqlSectionUtil;
@Repository
public class MajorDaoImpl implements MajorDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Major> findByMajorIdList(List<String> majorIdList) throws Exception {
		Session session = getSession();
		String hql = "FROM Major WHERE isDeleted='0' AND majorId IN "+new GenerateHqlSectionUtil().generateHql_IN(majorIdList);
		return session.createQuery(hql).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Major> findAll() throws Exception {
		Session session = getSession();
		return session.createQuery("FROM Major WHERE isDeleted='0'").list();
	}

	@Override
	public Major findByMajorId(String majorId) throws Exception {
		Session session = getSession();
		return (Major) session.createQuery("FROM Major WHERE majorId=? AND isDeleted='0'").setParameter(0, majorId)
				.uniqueResult();
	}

}
