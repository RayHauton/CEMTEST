package com.cem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.cem.dao.JobDao;
import com.cem.pojo.Companynature;
import com.cem.pojo.Income;
import com.cem.pojo.Jobcontitionmodule;
import com.cem.pojo.Jobinfomodule;
import com.cem.pojo.Transferjobcount;
import com.cem.pojo.User;

@Repository
public class JobDaoImp implements JobDao{
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Jobinfomodule findJobinfomoduleByUserId(long userId) throws Exception {
		Session session = getSession();
		String hql = "FROM Jobinfomodule job WHERE job.userId=? and job.isDeleted=? ";
		@SuppressWarnings("unchecked")
		List<Jobinfomodule> jobinfomodules = session.createQuery(hql).setParameter(0, userId).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return jobinfomodules.size() == 1 ? jobinfomodules.get(0) : null;
	}

	@Override
	public void deleteJobinfomodule(Jobinfomodule jobinfomodule) throws Exception {
		// TODO Auto-generated method stub
		jobinfomodule.setIsDeleted("1");
		Session session = getSession();
		session.update(jobinfomodule);
		
	}

	@Override
	public void updateJobinfomodule(Jobinfomodule jobinfomodule) throws Exception {
		// TODO Auto-generated method stub
		Session session  =getSession();
		session.update(jobinfomodule);
	}

	@Override
	public void insertJobinfomodule(Jobinfomodule jobinfomodule) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(jobinfomodule);
	}

	@Override
	public Companynature findCompanynatureByNaturId(String natureId) throws Exception {
		Session session = getSession();
		String hql = "FROM Companynature con WHERE con.natureId=? and con.isDeleted=? ";
		@SuppressWarnings("unchecked")
		List<Companynature> companynatures = session.createQuery(hql).setParameter(0, natureId).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return companynatures.size() == 1 ? companynatures.get(0) : null;
	}

	@Override
	public void deleteCompanynature(Companynature companynature) throws Exception {
		// TODO Auto-generated method stub
		companynature.setIsDeleted("1");
		Session session  =getSession();
		session.update(companynature);
		
	}

	@Override
	public void updataCompanynature(Companynature companynature) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.update(companynature);
		
	}

	@Override
	public void insertCompanynature(Companynature companynature) throws Exception {
		// TODO Auto-generated method stub
		Session session  =getSession();
		session.save(companynature);
	}

	@Override
	public Jobcontitionmodule findJobcontitionmoduleByUserId(long userId) throws Exception {
		Session session = getSession();
		String hql = "FROM Jobcontitionmodule job WHERE job.userId=? and job.isDeleted=? ";
		@SuppressWarnings("unchecked")
		List<Jobcontitionmodule> jobcontitionmodules = session.createQuery(hql).setParameter(0, userId).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return jobcontitionmodules.size() == 1 ? jobcontitionmodules.get(0) : null;
	}

	@Override
	public void deleteJobcontitionmodule(Jobcontitionmodule jobcontitionmodule) throws Exception {
		// TODO Auto-generated method stub
		jobcontitionmodule.setIsDeleted("1");
		Session session = getSession();
		session.update(jobcontitionmodule);
		
	}

	@Override
	public void updateJobcontitionmodule(Jobcontitionmodule jobcontitionmodule) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.update(jobcontitionmodule);
	}

	@Override
	public void insertJobcontitionmodule(Jobcontitionmodule jobcontitionmodule) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(jobcontitionmodule);
		
	}

	@Override
	public Income findIncomeByIncomeId(String incomeId) throws Exception {
		Session session = getSession();
		String hql = "FROM Income income WHERE income.incomeId=? and income.isDeleted=? ";
		@SuppressWarnings("unchecked")
		List<Income> incomes = session.createQuery(hql).setParameter(0, incomeId).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return incomes.size() == 1 ? incomes.get(0) : null;
	}

	@Override
	public void deleteIncome(Income income) throws Exception {
		// TODO Auto-generated method stub
		income.setIsDeleted("1");
		Session session  =getSession();
		session.update(income);
		
	}

	@Override
	public void updateIncome(Income income) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.update(income);
	}

	@Override
	public void insertIncome(Income income) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(income);
		
	}

	@Override
	public Transferjobcount findTransferjobcountByCountId(String countId) throws Exception {
		Session session = getSession();
		String hql = "FROM Transferjobcount tra WHERE tra.countId=? and tra.isDeleted=? ";
		@SuppressWarnings("unchecked")
		List<Transferjobcount> transferjobcounts = session.createQuery(hql).setParameter(0, countId).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return transferjobcounts.size() == 1 ? transferjobcounts.get(0) : null;
	}

	@Override
	public void deleteTransferjobcount(Transferjobcount transferjobcount) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTransferjobcount(Transferjobcount transferjobcount) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertTransferjobcount(Transferjobcount transferjobcount) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
