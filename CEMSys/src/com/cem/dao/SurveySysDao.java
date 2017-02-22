package com.cem.dao;

import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;

public interface SurveySysDao {

	/**
	 * 保存----个人能力品质
	 * @param selfabilityquality
	 */
	public void saveSelfabilityquality(Selfabilityquality selfabilityquality);
	
	/**
	 * 保存----专业能力培养
	 * @param majorabilitycultivationquality
	 */
	public void saveMajorabilitycultivationquality(Majorabilitycultivationquality majorabilitycultivationquality);
	
	/**
	 * 查找----个人能力品质----根据用户ID
	 * @param userID
	 * @return
	 */
	public Selfabilityquality SearchSelfabilityqualityByUserID(Long userID);
	
	/**
	 * 查找----专业能力培养----根据用户ID
	 * @param userID
	 * @return
	 */
	public Majorabilitycultivationquality SearchMajorabilitycultivationqualityByUserID(Long userID);
	
	/**
	 * 删除----个人能力品质----根据用户ID
	 * @param userID
	 */
	public void deleteSelfabilityqualityByUserID(Long userID);
	
	/**
	 * 删除----专业能力培养----根据用户ID
	 * @param userID
	 */
	public void deleteMajorabilitycultivationqualityByUserID(Long userID);
}
