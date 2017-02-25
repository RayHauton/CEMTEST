package com.cem.dao;

import java.util.Map;

import com.cem.queryVO.DonationQueryVo;

/*
 * 捐赠有关的数据访问层逻辑
 */
public interface DonationDao {
	/*
	 * 查询捐赠信息（带分页）
	 */
	public Map<String,Object> findAll(DonationQueryVo queryVo) throws Exception;
}
