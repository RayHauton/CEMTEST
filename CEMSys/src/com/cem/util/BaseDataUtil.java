package com.cem.util;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cem.pojo.Degree;
import com.cem.pojo.Major;
/*
 * 基础数据的获取工具类
 */
public class BaseDataUtil {
	private JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);
	/*
	 * 获取所有学位
	 */
	public List<Degree> getDegrees() throws Exception{
		String sql = "select * from degree";
		return jdbcTemplate.query(sql, this.getRowMapper(Degree.class));
	}
	/*
	 * 获取所有专业
	 */
	public List<Major> getMajors() throws Exception{
		String sql = "select * from major";
		return jdbcTemplate.query(sql, this.getRowMapper(Major.class));
	}
	public <T> RowMapper<T> getRowMapper(Class<T> clazz){
		return new BeanPropertyRowMapper<>(clazz);
	}
	
}
