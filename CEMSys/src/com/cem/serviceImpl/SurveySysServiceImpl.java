package com.cem.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.SurveySysDao;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.service.SurveySysService;

@Service
public class SurveySysServiceImpl implements SurveySysService {

	public SurveySysServiceImpl() {	}

	@Autowired
	SurveySysDao surveySysDao = null;
	
	public void saveSelfabilityquality(Selfabilityquality selfabilityquality) {
		surveySysDao.saveSelfabilityquality(selfabilityquality);
	}

	@Override
	public void saveMajorabilitycultivationquality(Majorabilitycultivationquality majorabilitycultivationquality) {
		surveySysDao.saveMajorabilitycultivationquality(majorabilitycultivationquality);
	}

	@Override
	public Selfabilityquality SearchSelfabilityqualityByUserID(String userID) {
		return surveySysDao.SearchSelfabilityqualityByUserID(userID);
	}

	@Override
	public Majorabilitycultivationquality SearchMajorabilitycultivationqualityByUserID(String userID) {
		return surveySysDao.SearchMajorabilitycultivationqualityByUserID(userID);
	}

	@Override
	public void deleteSelfabilityqualityByUserID(String userID) {
		surveySysDao.deleteSelfabilityqualityByUserID(userID);
	}

	@Override
	public void deleteMajorabilitycultivationqualityByUserID(String userID) {
		surveySysDao.deleteMajorabilitycultivationqualityByUserID(userID);
	}


}
