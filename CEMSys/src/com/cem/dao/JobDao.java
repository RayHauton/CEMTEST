package com.cem.dao;

import com.cem.pojo.Companynature;
import com.cem.pojo.Income;
import com.cem.pojo.Jobcontitionmodule;
import com.cem.pojo.Jobinfomodule;
import com.cem.pojo.Transferjobcount;

public interface JobDao {
	
	
	public Jobinfomodule findJobinfomoduleByUserId(int userId) throws Exception;
	public boolean updateJobinfomodule(Jobinfomodule jobinfomodule) throws Exception;
	public boolean deleteJobinfomodule(int useId) throws Exception;
	public void insertJobinfomodule(Jobinfomodule jobinfomodule) throws Exception;
	
	public Companynature findCompanynatureByNaturId(String natureId) throws Exception;
	public void deleteCompanynature(Companynature companynature) throws Exception;
	public void updataCompanynature(Companynature companynature) throws Exception;
	public void insertCompanynature(Companynature companynature) throws Exception;
	
	public Jobcontitionmodule findJobcontitionmoduleByUserId(int userId) throws Exception;
	public boolean updateJobcontitionmodule(Jobcontitionmodule jobcontitionmodule) throws Exception;
	public boolean deleteJobcontitionmodule(int useId) throws Exception;
	public void insertJobcontitionmodule(Jobcontitionmodule jobcontitionmodule) throws Exception;
	
	public Income findIncomeByIncomeId(String incomeId) throws Exception;
	public void deleteIncome(Income income) throws Exception;
	public void updateIncome(Income income) throws Exception;
	public void insertIncome(Income income) throws Exception;
	
	public Transferjobcount findTransferjobcountByCountId(String countId) throws Exception;
	public void deleteTransferjobcount(Transferjobcount transferjobcount) throws Exception;
	public void updateTransferjobcount(Transferjobcount transferjobcount) throws Exception;
	public void insertTransferjobcount(Transferjobcount transferjobcount) throws Exception;
	
	
}
