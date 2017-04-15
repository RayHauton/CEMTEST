package com.cem.test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cem.controller.MajorController;
import com.cem.customPojo.UserCustom;
import com.cem.dao.DonationDao;
import com.cem.daoImpl.DonationDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class DaoTest {
	@Resource
	MajorController majorController;
	@Test
	public void testFindDonorInfo() throws Exception{
		UserCustom userCustom = new UserCustom();
		userCustom.setUserId(1);
		DonationDao donationDao = new DonationDaoImpl();
		UserCustom user = donationDao.findDonorInfo(userCustom);
	}
	@Test
	public void testFindDegreeId() throws Exception{
	}
}
