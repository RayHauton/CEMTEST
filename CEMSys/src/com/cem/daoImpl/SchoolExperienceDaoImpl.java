package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.MajorDao;
import com.cem.dao.SchoolExperienceDao;
import com.cem.pojo.Major;
import com.cem.pojo.Schoolexperience;

@Repository
public class SchoolExperienceDaoImpl implements SchoolExperienceDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MajorDao majorDao;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Schoolexperience findBySchoolExpericenceId(String SEId) throws Exception {
		Session session = getSession();
		return (Schoolexperience) session.createQuery("FROM Schoolexperience se WHERE se.isDeleted='0' AND se.SEId=?")
				.setParameter(0, SEId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Major> findMajorsByDegreeId(String degreeId) throws Exception {
		Session session = getSession();
		List<String> majorIds = session.createQuery("FROM Schoolexperience se WHERE se.degreeId=?")
				.setParameter(0, degreeId).list();
		return majorDao.findByMajorIdList(majorIds);
	}

}















