package com.cem.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cem.dao.RecruitmentDao;
import com.cem.pojo.Recruitment;
@Repository("recruitmentDao")
public class RecruitmentDaoImpl implements RecruitmentDao{
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void insertRecruitment(Recruitment recruitment) throws Exception {
		Session session = getSession();
		session.save(recruitment);
	}
}
