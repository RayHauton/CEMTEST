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

	/**
	 * 根据专业id和学位id查找对应的学历记录id
	 * 可以传入UserCustom类 或者degreeId， majorId，二者前后顺序不能颠倒
	 * @param condition UserCustom 或 degreeId，majorID，顺序不能颠倒
	 * @return 学历Id
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T> Schoolexperience findSchoolExperienceByMajorIdAndDegreeId(T... condition) throws Exception;
}
