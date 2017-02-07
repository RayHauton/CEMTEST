package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.DegreeDao;
import com.cem.pojo.Degree;
@Repository
public class DegreeDaoImpl implements DegreeDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Degree> findAll() throws Exception {
		Session session = getSession();
		return session.createQuery("FROM Degree WHERE isDeleted='0'").list();
	}

	@Override
	public Degree findByDegreeId(String degreeId) throws Exception {
		Session session = getSession();
		return (Degree) session.createQuery("FROM Degree WHERE degreeId=? AND isDeleted=?").setParameter(0, degreeId)
				.setParameter(1, "0").uniqueResult();
	}

}
