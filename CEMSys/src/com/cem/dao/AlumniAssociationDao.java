package com.cem.dao;

import java.util.List;

import com.cem.pojo.AlumniAssociation;

/**
 * 校友会数据访问接口
 * @author linhd
 *
 */
public interface AlumniAssociationDao {
	/**
	 * 根据id查找校友会信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AlumniAssociation findById(Integer id) throws Exception;
	
	/**
	 * 更新校友会信息
	 * @param alumniAssociation
	 * @throws Exception
	 */
	public void merge(AlumniAssociation alumniAssociation) throws Exception;
	
	/**
	 * 添加校友会信息
	 * @param alumniAssociation 校友会实体类
	 * @throws Exception
	 */
	public void insert(AlumniAssociation alumniAssociation) throws Exception;
	
	/**
	 * 
	 * @return 校友会集合
	 * @throws Exception
	 */
	public List<AlumniAssociation> findAll() throws Exception;
}
