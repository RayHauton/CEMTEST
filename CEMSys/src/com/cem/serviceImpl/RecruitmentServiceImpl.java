package com.cem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.RecruitmentDao;
import com.cem.pojo.Recruitment;
import com.cem.service.RecruitmentService;
@Service("recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService{
	@Autowired
	private RecruitmentDao recruitmentDao;
	
	@Override
	public void insertRecruitment(Recruitment recruitment) throws Exception {
		recruitmentDao.insertRecruitment(recruitment);
	}
}
