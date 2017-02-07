package com.cem.dao;

import java.util.List;

import com.cem.pojo.Major;

public interface MajorDao {
	/*
	 * 查询全部专业
	 */
	public List<Major> findAll() throws Exception;

	/*
	 * 根据一个id查询专业信息
	 */
	public Major findByMajorId(String majorId) throws Exception;

	/*
	 * 根据多个id查询专业信息
	 */
	public List<Major> findByMajorIdList(List<String> majorIdList) throws Exception;
}