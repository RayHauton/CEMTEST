package com.cem.service;

import java.util.List;

import com.cem.customPojo.MajorCustom;
import com.cem.pojo.Major;

public interface MajorService {

	/**
	 * 更新专业信息
	 * 
	 * @param major
	 * @throws Exception
	 */
	public void merge(Major major) throws Exception;

	public String findMaxId() throws Exception;

	public List<MajorCustom> findAllWithDegreeInfo() throws Exception;

	public void insert(Major major) throws Exception;

	/*
	 * 查询全部专业
	 */
	public List<Major> findAll() throws Exception;

	/*
	 * 根据id查询专业信息
	 */
	public Major findByMajorId(String majorId) throws Exception;
	

	/*
	 * 根据多个id查询专业信息
	 */
	public List<Major> findByMajorIdList(List<String> majorIdList) throws Exception;
}
