package com.cem.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.AdminSurveySysDao;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;
import com.cem.service.AdminSurveySysService;


@Service
public class AdminSurveySysServiceImpl implements AdminSurveySysService {

	@Autowired
	AdminSurveySysDao adminSurveySysDao = null;
	
	@Override
	public List<Integer> searchSMCondition(String[] titleNum,String[] scoreNum) {
		return adminSurveySysDao.searchSMCondition(titleNum, scoreNum);
	}

	@Override
	public User searchUserByUserId(int userId) {
		return adminSurveySysDao.searchUserByUserId(userId);
	}

	@Override
	public void dataToExcel(List<User> userList,List<Selfabilityquality> sList,List<Majorabilitycultivationquality> mList) throws Exception {
		adminSurveySysDao.dataToExcel(userList,sList,mList);
	}

	@Override
	public void download() throws Exception {
		adminSurveySysDao.download();
	}

	@Override
	public String[] searchAllUser() throws Exception {
		return adminSurveySysDao.searchAllUser();
	}

}
