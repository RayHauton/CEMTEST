package com.cem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.JobDao;
import com.cem.pojo.Companynature;
import com.cem.pojo.Income;
import com.cem.pojo.Jobcontitionmodule;
import com.cem.pojo.Jobinfomodule;
import com.cem.pojo.Transferjobcount;
import com.cem.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	JobDao jobDao = null;

	@Override
	public Companynature findComNature(String natureId) throws Exception {
		// TODO Auto-generated method stub
		return jobDao.findCompanynatureByNaturId(natureId);

	}

	@Override
	public Jobinfomodule findJobInfByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return jobDao.findJobinfomoduleByUserId(userId);
	}

	@Override
	public void insertJobInf(Jobinfomodule jobinfomodule) throws Exception {
		// TODO Auto-generated method stub
		jobDao.insertJobinfomodule(jobinfomodule);
	}

	@Override
	public boolean deleteJobInf(int userId) throws Exception {
		// TODO Auto-generated method stub
		
		if(jobDao.deleteJobinfomodule(userId))
			return true;
		else {
			return false;
		}
		
	}

	@Override
	public Transferjobcount findTranCountByCountId(String countId) throws Exception {
		// TODO Auto-generated method stub
		return jobDao.findTransferjobcountByCountId(countId);
	}

	@Override
	public Income findIncomeByIncomeId(String incomeId) throws Exception {
		// TODO Auto-generated method stub
		return jobDao.findIncomeByIncomeId(incomeId);
	}

	@Override
	public void insertJobCon(Jobcontitionmodule jobcontitionmodule) throws Exception {
		// TODO Auto-generated method stub
		jobDao.insertJobcontitionmodule(jobcontitionmodule);
	}

	@Override
	public Jobcontitionmodule finJobConByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		jobDao.findJobcontitionmoduleByUserId(userId);
		return null;
	}

	@Override
	public boolean deleteJobCon(int userId) throws Exception {
		// TODO Auto-generated method stub
		if(jobDao.deleteJobcontitionmodule(userId))
			return true;
		else {
			return false;
		}
	}

}
