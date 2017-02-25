package com.cem.service;

import java.util.Map;

import com.cem.customPojo.UserCustom;
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
}
