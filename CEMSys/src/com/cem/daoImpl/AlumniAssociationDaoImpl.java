package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.AlumniAssociationDao;
import com.cem.pojo.AlumniAssociation;

@Repository
public class AlumniAssociationDaoImpl implements AlumniAssociationDao {

	@Autowired
	SessionFactory sessionFactory = null;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public AlumniAssociation findById(Integer id) throws Exception {
		return (AlumniAssociation) getSession()
				.createQuery("FROM AlumniAssociation aa WHERE aa.isDeleted='0' AND aa.alumniAssociationId=" + id)
				.uniqueResult();
	}

	@Override
	public void merge(AlumniAssociation alumniAssociation) throws Exception {
		getSession().merge(alumniAssociation);
	}

	/**
	 * 添加校友会信息
	 * 
	 * @param alumniAssociation
	 * @throws Exception
	 */
	@Override
	public void insert(AlumniAssociation alumniAssociation) throws Exception {
		Session session = getSession();
		session.save(alumniAssociation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AlumniAssociation> findAll() throws Exception {
		Session session = getSession();
		String hql = "FROM AlumniAssociation aa WHERE aa.isDeleted='0' ORDER BY aa.alumniAssociationId desc";
		return session.createQuery(hql).list();
	}

}
