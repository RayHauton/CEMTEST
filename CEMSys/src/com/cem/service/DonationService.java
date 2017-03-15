package com.cem.service;

import java.util.Map;

import com.cem.customPojo.UserCustom;
import com.cem.pojo.Donation;
import com.cem.queryVO.DonationQueryVo;

public interface DonationService {
	/*
	 * 查询某几个条件的所有记录
	 */
	public Map<String, Object> findAll(DonationQueryVo queryVo) throws Exception;

	/*
	 * 查找相应捐赠人的部分信息
	 */
	public UserCustom findDonorInfo(UserCustom userCustom) throws Exception;

	/*
	 * 添加捐赠记录
	 */
	public void insert(Donation donation) throws Exception;

	/*
	 * 根据捐赠记录ID删除记录
	 */
	public void delete(Integer donationId) throws Exception;

	/*
	 * 更新捐赠记录
	 */
	public void update(Donation donation) throws Exception;
}
