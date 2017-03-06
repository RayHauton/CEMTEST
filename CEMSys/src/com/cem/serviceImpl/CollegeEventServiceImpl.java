package com.cem.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.CollegeEventDao;
import com.cem.pojo.Collegeevent;
import com.cem.queryVO.CollegeEventQueryVo;
import com.cem.service.CollegeEventService;
@Service
public class CollegeEventServiceImpl implements CollegeEventService {
	@Autowired
	private CollegeEventDao collegeEventDao;
	
	
	@Override
	public void add(Collegeevent collegeevent) throws Exception {
		/*
		 * 对将要被持久化的pojo进行业务处理
		 */
		collegeevent.setIsDeleted("0");
		collegeEventDao.add(collegeevent);
	}

	@Override
	public Map<String, Object> findAll(CollegeEventQueryVo colgEvntQueryVo) throws Exception {
		return null;
	}

}
