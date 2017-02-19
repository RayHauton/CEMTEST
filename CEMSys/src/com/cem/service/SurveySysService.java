package com.cem.service;

import javax.servlet.http.HttpServletRequest;

import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;

public interface SurveySysService {
	
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
	 */
	public Selfabilityquality SearchSelfabilityqualityByUserID(String userID);
	
	/**
	 * 查找----专业能力培养----根据用户ID
	 * @param userID
	 * @return
	 */
	public Majorabilitycultivationquality SearchMajorabilitycultivationqualityByUserID(String userID);
	
	/**
	 * 删除----个人能力品质----根据用户ID
	 * @param userID
	 */
	public void deleteSelfabilityqualityByUserID(String userID);
	
	/**
	 * 删除----专业能力培养----根据用户ID
	 * @param userID
	 */
	public void deleteMajorabilitycultivationqualityByUserID(String userID);
}
