package com.cem.daoImpl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.SurveySysDao;
import com.cem.pojo.Major;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.util.GenerateHqlSectionUtil;
@Repository
public class SurveySysDaoImpl implements SurveySysDao {

	public SurveySysDaoImpl() {}
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveSelfabilityquality(Selfabilityquality selfabilityquality) {
		Session session = getSession();
		if(selfabilityquality!=null){
			session.saveOrUpdate(selfabilityquality);
		}
	}

	@Override
	public void saveMajorabilitycultivationquality(Majorabilitycultivationquality majorabilitycultivationquality) {
		Session session = getSession();
		if(majorabilitycultivationquality!=null)
			session.saveOrUpdate(majorabilitycultivationquality);
	}

	@Override
	public Selfabilityquality SearchSelfabilityqualityByUserID(String userID) {
		Session session = sessionFactory.openSession();//这个地方如果用getCurrentSession会报错，不知道为什么；
		Selfabilityquality selfabilityquality = (Selfabilityquality) session.get(Selfabilityquality.class,userID);
		if(selfabilityquality.getIsDelete()==Short.valueOf("1"))
			return null;
		else 
			return selfabilityquality;
	}

	@Override
	public Majorabilitycultivationquality SearchMajorabilitycultivationqualityByUserID(String userID) {
		Session session = sessionFactory.openSession();;
		Majorabilitycultivationquality majorabilitycultivationquality = (Majorabilitycultivationquality) session.get(Majorabilitycultivationquality.class, userID);
		if(majorabilitycultivationquality.getIsDelete()==Short.valueOf("1"))
			return null;
		else 
			return majorabilitycultivationquality;
	}

	@Override
	public void deleteSelfabilityqualityByUserID(String userID) {
		Session session = getSession();
		String hql="update Selfabilityquality s set s.isDelete=1 where s.userId='"+userID+"';";
		session.createSQLQuery(hql).executeUpdate();
	}

	@Override
	public void deleteMajorabilitycultivationqualityByUserID(String userID) {
		Session session = getSession();
		String hql="update Majorabilitycultivationquality m set m.isDelete=1 where m.userId="+userID+";";
		session.createSQLQuery(hql).executeUpdate();
	}
	

}
