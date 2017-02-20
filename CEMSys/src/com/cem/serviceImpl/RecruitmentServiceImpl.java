package com.cem.serviceImpl;

import java.util.List;

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

	@Override
	public List<Recruitment> findAll(int pageIndex,int pageSize) throws Exception {
		return recruitmentDao.findAll(pageIndex,pageSize);
	}
}
