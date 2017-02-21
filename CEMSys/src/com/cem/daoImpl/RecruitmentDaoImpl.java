package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.RecruitmentDao;
import com.cem.pojo.Recruitment;

@Repository("recruitmentDao")
public class RecruitmentDaoImpl implements RecruitmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insertRecruitment(Recruitment recruitment) throws Exception {
		Session session = getSession();
		session.save(recruitment);
	}

	@Override
	public List<Recruitment> findAll(int pageIndex, int pageSize) throws Exception {
		Session session = getSession();
		@SuppressWarnings("unchecked")
		List<Recruitment> recruitmentList = session.createQuery("FROM Recruitment re WHERE re.isDeleted='0' ORDER BY re.publishDate desc")
				.setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageIndex * pageSize).list();
		return recruitmentList;
	}
}
