package com.cem.dao;

import java.util.List;

import com.cem.pojo.Degree;

public interface DegreeDao {
	/*
	 * 查找全部记录
	 */
	public List<Degree> findAll() throws Exception;

	/*
	 * 根据id查找学位记录
	 */
	public Degree findByDegreeId(String degreeId) throws Exception;

}
