package com.cem.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cem.pojo.Degree;
import com.cem.pojo.Major;

/*
 * 基础数据的获取工具类
 */
public class BaseDataUtil {
	private static List<Integer> pageSizes;
	private static Properties properties;
	private static Integer defaultPageSize;
	private static String fileUploadPath;
	private JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);

	static {
		pageSizes = new ArrayList<>();
		properties = new Properties();
		try {
			/*
			 * 读取配置文件相关信息
			 */
			properties.load(BaseDataUtil.class.getClassLoader().getResourceAsStream("config/baseDataStorage.properties"));
			String pageSizeString = properties.getProperty("pageSize");
			defaultPageSize = Integer.parseInt(properties.getProperty("defaultPageSize"));
			fileUploadPath = properties.getProperty("file.path");
			String[] pageSizeArray = pageSizeString.split(",");
			pageSizes = new ArrayList<>(pageSizeArray.length);
			for(String item:pageSizeArray){
				pageSizes.add(Integer.parseInt(item));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取页面显示记录条数的集中情况
	 */
	public static List<Integer> getPageSizes(){
		return pageSizes;
	}
	
	/*
	 * 获取文件上传路径
	 */
	public static String getFileUploadPath(){
		return fileUploadPath;
	}
	
	/*
	 * 获取默认显示记录数
	 */
	public static Integer getDefaultPageSize(){
		return defaultPageSize;
	}
	
	/*
	 * 获取所有学位
	 */
	public List<Degree> getDegrees() throws Exception {
		String sql = "select * from degree";
		return jdbcTemplate.query(sql, this.getRowMapper(Degree.class));
	}

	/*
	 * 获取所有专业
	 */
	public List<Major> getMajors() throws Exception {
		String sql = "select * from major";
		return jdbcTemplate.query(sql, this.getRowMapper(Major.class));
	}

	public <T> RowMapper<T> getRowMapper(Class<T> clazz) {
		return new BeanPropertyRowMapper<>(clazz);
	}

}
