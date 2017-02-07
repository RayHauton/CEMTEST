package com.cem.service;

import java.util.List;

import com.cem.pojo.Degree;

public interface DegreeService {
	/*
	 * 查找全部记录
	 */
	public List<Degree> findAll() throws Exception;

	/*
	 * 根据id查找记录
	 */
	public Degree findByDegreeId(String degreeId) throws Exception;
}
