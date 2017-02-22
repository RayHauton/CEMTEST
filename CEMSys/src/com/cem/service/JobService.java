package com.cem.service;

import com.cem.pojo.Companynature;
import com.cem.pojo.Income;
import com.cem.pojo.Jobcontitionmodule;
import com.cem.pojo.Jobinfomodule;
import com.cem.pojo.Transferjobcount;

public interface JobService {
	public Companynature findComNature(String natureId) throws Exception;
	public Jobinfomodule findJobInfByUserId(long userId) throws Exception;
	public void insertJobInf(Jobinfomodule jobinfomodule) throws Exception;
	public void deleteJobInf(Jobinfomodule jobinfomodule) throws Exception;
	public Transferjobcount findTranCountByCountId(String countId) throws Exception;
	public Income findIncomeByIncomeId(String incomeId) throws Exception;
	public void insertJobCon(Jobcontitionmodule jobcontitionmodule) throws Exception;
}

