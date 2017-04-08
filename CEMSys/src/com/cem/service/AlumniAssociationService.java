package com.cem.service;

import java.util.List;

import com.cem.pojo.AlumniAssociation;

/**
 * 校友会业务接口
 * @author linhd
 *
 */
public interface AlumniAssociationService {
	public AlumniAssociation findById(Integer id) throws Exception;
	/**
	 * 更新校友会信息
	 * @param alumniAssociation
	 * @throws Exception
	 */
	public void merge(AlumniAssociation alumniAssociation) throws Exception;
	
	/**
	 * 添加校友会记录
	 * @param alumniAssociation
	 * @throws Exception
	 */
	public void insert(AlumniAssociation alumniAssociation) throws Exception;
	/**
	 * 获取所有校友会信息
	 * @return
	 * @throws Exception
	 */
	public List<AlumniAssociation> findAll() throws Exception;
}
