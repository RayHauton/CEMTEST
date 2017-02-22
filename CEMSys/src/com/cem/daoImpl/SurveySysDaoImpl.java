package com.cem.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.SurveySysDao;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;

@Repository
public class SurveySysDaoImpl implements SurveySysDao {

	public SurveySysDaoImpl() {
	}

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveSelfabilityquality(Selfabilityquality selfabilityquality) {
		Session session = getSession();
		if (selfabilityquality != null) {
			session.saveOrUpdate(selfabilityquality);
		}
	}

	@Override
	public void saveMajorabilitycultivationquality(Majorabilitycultivationquality majorabilitycultivationquality) {
		Session session = getSession();
		if (majorabilitycultivationquality != null)
			session.saveOrUpdate(majorabilitycultivationquality);
	}

	@Override
	public Selfabilityquality SearchSelfabilityqualityByUserID(Long userID) {
		Session session = getSession();// 这个地方如果用getCurrentSession会报错，是因为没有延长session的作用范围；
		Selfabilityquality selfabilityquality = (Selfabilityquality) session.load(Selfabilityquality.class, userID);
		if (selfabilityquality != null && selfabilityquality.getIsDeleted().equals("1") == false)
			return selfabilityquality;
		else
			return null;
	}

	@Override
	public Majorabilitycultivationquality SearchMajorabilitycultivationqualityByUserID(Long userID) {
		Session session = getSession();
		Majorabilitycultivationquality majorabilitycultivationquality = (Majorabilitycultivationquality) session
				.load(Majorabilitycultivationquality.class, userID);
		if (majorabilitycultivationquality != null
				&& majorabilitycultivationquality.getIsDeleted().equals("1") == false)
			return majorabilitycultivationquality;
		else
			return null;
	}

	@Override
	public void deleteSelfabilityqualityByUserID(Long userID) {
		Session session = getSession();
		String hql = "update Selfabilityquality s set s.isDeleted=1 where s.userId='" + userID + "';";
		session.createSQLQuery(hql).executeUpdate();
	}

	@Override
	public void deleteMajorabilitycultivationqualityByUserID(Long userID) {
		Session session = getSession();
		String hql = "update Majorabilitycultivationquality m set m.isDeleted=1 where m.userId=" + userID + ";";
		session.createSQLQuery(hql).executeUpdate();
	}

}
