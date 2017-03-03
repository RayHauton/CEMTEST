package com.cem.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.customPojo.UserCustom;
import com.cem.dao.DonationDao;
import com.cem.queryVO.DonationQueryVo;
import com.cem.service.DonationService;
@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationDao donationDao;
	
	@Override
	public Map<String, Object> findAll(DonationQueryVo queryVo) throws Exception {
		return donationDao.findAll(queryVo);
	}

	@Override
	public UserCustom findDonorInfo(UserCustom userCustom) throws Exception {
		return donationDao.findDonorInfo(userCustom);
	}
	

}
