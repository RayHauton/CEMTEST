package com.cem.service;

import java.util.Map;

import com.cem.pojo.Collegeevent;
import com.cem.queryVO.CollegeEventQueryVo;

/*
 * 学院大事件service接口
 */
public interface CollegeEventService {
	/*
	 * 添加学院大事件
	 */
	public void add(Collegeevent collegeevent) throws Exception;

	/*
	 * 获取学院大事件
	 */
	public Map<String, Object> findAll(CollegeEventQueryVo colgEvntQueryVo) throws Exception;

	/*
	 * 根据id获取学院事件
	 */
	public Collegeevent findById(Integer eventId) throws Exception;

	/*
	 * 更新学院事件记录
	 */
	public void saveOrUpdate(Collegeevent collegeevent) throws Exception;
}
