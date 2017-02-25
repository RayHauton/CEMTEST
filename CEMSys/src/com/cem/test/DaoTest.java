package com.cem.test;

import org.junit.Test;

import com.cem.customPojo.UserCustom;
import com.cem.dao.DonationDao;
import com.cem.daoImpl.DonationDaoImpl;

public class DaoTest {
	@Test
	public void testFindDonorInfo() throws Exception{
		UserCustom userCustom = new UserCustom();
		userCustom.setUserId(1);
		DonationDao donationDao = new DonationDaoImpl();
		UserCustom user = donationDao.findDonorInfo(userCustom);
	}
}
