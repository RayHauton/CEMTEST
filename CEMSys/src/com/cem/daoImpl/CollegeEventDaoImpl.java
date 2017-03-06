package com.cem.daoImpl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.CollegeEventDao;
import com.cem.pojo.Collegeevent;
import com.cem.queryVO.CollegeEventQueryVo;

@Repository
public class CollegeEventDaoImpl implements CollegeEventDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Collegeevent collegeevent) throws Exception {
		Session session = getSession();
		session.save(collegeevent);
	}

	@Override
	public Map<String, Object> findAll(CollegeEventQueryVo colgEvntQueryVo) throws Exception {
		return null;
	}

}
