package com.cem.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.RecruitmentDao;
import com.cem.pojo.Recruitment;
import com.cem.queryVO.RecruitmentQueryVo;
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
	public Map<String, Object> findAll(RecruitmentQueryVo queryVo) throws Exception {
		return recruitmentDao.findAll(queryVo);
	}
}
