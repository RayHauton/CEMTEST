package com.cem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.SchoolExperienceDao;
import com.cem.pojo.Major;
import com.cem.pojo.Schoolexperience;
import com.cem.service.SchoolExperienceService;

@Service
public class SchoolExperienceServiceImpl implements SchoolExperienceService {
	@Autowired
	private SchoolExperienceDao schoolExperienceDao;

	@Override
	public Schoolexperience findBySchoolExpericenceId(String SEId) throws Exception {
		return schoolExperienceDao.findBySchoolExpericenceId(SEId);
	}

	@Override
	public List<Major> findMajorsByDegreeId(String degreeId) throws Exception {
		return schoolExperienceDao.findMajorsByDegreeId(degreeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Schoolexperience findSchoolExperienceByMajorIdAndDegreeId(T... condition) throws Exception {
		return schoolExperienceDao.findSchoolExperienceByMajorIdAndDegreeId(condition);
	}

}
