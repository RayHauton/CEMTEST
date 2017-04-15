package com.cem.dao;

import java.util.List;

import com.cem.customPojo.MajorCustom;
import com.cem.pojo.Major;

public interface MajorDao {
	/**
	 * 更新专业信息
	 * @param major
	 * @throws Exception
	 */
	public void merge(Major major) throws Exception;
	
	
	/**
	 * 查找最大的degreeId标号
	 */
	public String findMaxId() throws Exception;
	
	/**
	 * 查找所有的专业信息（附带学位信息）
	 * @return
	 * @throws Exception
	 */
	public List<MajorCustom> findAllWithDegreeInfo() throws Exception;
	/**
	 * 新增记录
	 * @param major
	 * @throws Exception
	 */
	public void insert(Major major) throws Exception;
	
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
