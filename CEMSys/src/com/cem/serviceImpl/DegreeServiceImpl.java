package com.cem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.DegreeDao;
import com.cem.pojo.Degree;
import com.cem.service.DegreeService;
@Service
public class DegreeServiceImpl implements DegreeService {

	@Autowired
	private DegreeDao degreeDao;

	@Override
	public List<Degree> findAll() throws Exception {
		return degreeDao.findAll();
	}

	@Override
	public Degree findByDegreeId(String degreeId) throws Exception {
		return degreeDao.findByDegreeId(degreeId);
	}

}
