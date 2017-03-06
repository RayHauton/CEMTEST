package com.cem.dao;

import java.util.Map;

import com.cem.pojo.Collegeevent;
import com.cem.queryVO.CollegeEventQueryVo;

/**
 * 学园事件录
 * @author RayHauton
 *
 */
public interface CollegeEventDao {
	/*
	 * 添加学院大事件
	 */
	public void add(Collegeevent collegeevent) throws Exception;

	/*
	 * 获取学院大事件
	 */
	public Map<String, Object> findAll(CollegeEventQueryVo colgEvntQueryVo) throws Exception;
}
