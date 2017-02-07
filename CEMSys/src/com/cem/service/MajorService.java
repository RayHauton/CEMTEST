package com.cem.service;

import java.util.List;

import com.cem.pojo.Major;

public interface MajorService {
	/*
	 * 查询全部专业
	 */
	public List<Major> findAll() throws Exception;

	/*
	 * 根据id查询专业信息
	 */
	public Major findByMajorId(String majorId) throws Exception;
}
