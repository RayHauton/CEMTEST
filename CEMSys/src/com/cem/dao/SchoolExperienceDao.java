package com.cem.dao;

import java.util.List;

import com.cem.pojo.Major;
import com.cem.pojo.Schoolexperience;

public interface SchoolExperienceDao {
	/*
	 * 根据Id查询记录（感觉一般很少用）
	 */
	public Schoolexperience findBySchoolExpericenceId(String SEId) throws Exception;

	/*
	 * 根据学位id查询该学位有哪些专业
	 */
	public List<Major> findMajorsByDegreeId(String degreeId) throws Exception;
}