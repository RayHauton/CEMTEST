package com.cem.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.SqlASTFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cem.pojo.User;
import com.cem.util.BeanUtil;

public class ForumTest {
//	@Test
//	public void timeTest(){
//		Date date = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//		System.out.println(simpleDateFormat.format(date));
//	}
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
//	@Test
//	public void insertTest(){
//		try{
//			org.springframework.context.ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
//			DataSource dataSource = (DataSource) context.getBean("dataSource");
//			Date date = new Date();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//			SqlUpdate insert = new SqlUpdate();
//			insert.setDataSource(dataSource);
//			insert.setSql("insert into forum(forumId,forumTitle,userId,publishTime) values(null,?,?,?)");
//			insert.declareParameter(new SqlParameter("forumTitle", Types.VARCHAR));
//			insert.declareParameter(new SqlParameter("userId",Types.VARCHAR));
//			insert.declareParameter(new SqlParameter("publishTime",Types.VARCHAR));
//			Object[] parameters = new Object[]{
//					new String("发布测试"),new String("id001"),new String(simpleDateFormat.format(date))	
//			};
//			insert.update(parameters);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		}
	
//	public void UUIDTest(){
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid.toString());
//	}
//	@Test
//	public void test(){
//		try {
//			String pagenumber = null;
//			System.out.println(Integer.valueOf(pagenumber));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//	}
	
//	@Test
//	public void test(){
//		try {
//			JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);
//			String sql = "update forum set isDeleted='1' where forumId='2'";
//			int result = jdbcTemplate.update(sql);
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void tets(){
//		JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);
//		String sql = "update Forum set viewCount = viewCount+1 where forumId='13'";
//		int result = jdbcTemplate.update(sql);
//		System.out.println(result);
//	}
	
	public void test(){
		try {
			JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);
			String sql = "select email from User where classNo LIKE '09__2%'";
			List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
//	@Test
//	public void time() throws ParseException{
//		String date = "2012-12-2 15:20:20";
//		
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date));
//		
//		Date date2 = new Date();
//		System.out.println(date2.toString());
//	}
//	
	public String getFriendlyTime(String date) throws ParseException{
		Date nowTime = new Date();
		Date oldtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
//		//精确到哪一个时间点
		long ys = DateUtils.truncate(nowTime, Calendar.YEAR).getTime();//当前时间精确到年
		long ds = DateUtils.truncate(nowTime, Calendar.DAY_OF_MONTH).getTime();//当前时间精确到日
		long yd = DateUtils.truncate(oldtime, Calendar.DAY_OF_MONTH).getTime();//转换时间精确到日
		
		long n = nowTime.getTime();
		long e = oldtime.getTime();
		if (e < ys) {//时间转换成y-m-d//去年的
			return new SimpleDateFormat("yyyy-MM-dd").format(oldtime);
		}
		if ((ds - yd) == (24 * 60 * 60 * 1000)) {//24h内
			return new SimpleDateFormat("昨天  HH:mm").format(oldtime);
		}
		if (e < ds) {//今天以前的信息
			return new SimpleDateFormat("yyyy-MM-dd").format(oldtime);
		}
		if (n - e > 60 * 60 * 1000) {
			return new SimpleDateFormat("今天  HH:mm").format(oldtime);
		}
		if (n - e > 60 * 1000) {
			//1d 是double 自动转换
			return (long) Math.floor((n - e) * 1d / 60000) + "分钟前";
		}
		if (n - e > 1 * 1000) {
			return "刚刚";
		}
		return date;
	}
//	@Test
//	public void test() throws ParseException{
//		System.out.println(getFriendlyTime("2017-3-6 15:30:12"));
//	}
	
	public void test12313(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(new Date());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);
		String sql = "update User set role='1010101' DATEDIFF(DATE_FORMAT('" + today + "',%m-%d),DATE_FORMAT(birth)) = 0";
	}
	@Test
	public void testjlsadf(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);
		String sql = "SELECT DATEDIFF(CONCAT('2000',DATE_FORMAT('2017-1-15','-%m-%d')),CONCAT('2000',DATE_FORMAT('2017-1-1','-%m-%d')))";
	}
	
	public void test1(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateFormat.format(new Date()));
	}
	
	@Test 
	public void test2(){
		JdbcTemplate jdbcTemplate =  (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class); 
		String sql = "select * from user where DATEDIFF('2017-04-09',birth) >= 0";
		List<Map<String, Object>> log = new ArrayList<>();
		List<User> list = new ArrayList<>();
		try {
			log = jdbcTemplate.queryForList(sql);
			for (Map<String, Object> map : log) {
				User user = new User();
				user.setUserId((int) map.get("userId"));
				user.setUsername((String) map.get("username"));
				user.setTruename((String) map.get("truename"));
				user.setSex((String) map.get("sex"));
				user.setStudNumber((String) map.get("studNumber"));
				user.setBirth((String) map.get("birth"));
				user.setMobile((String) map.get("mobile"));
				user.setEmail((String) map.get("email"));
				user.setEntranceDate((String) map.get("entranceDate"));
				user.setGraduateDate((String) map.get("graduateDate"));
				user.setSchoolExperienceId((String) map.get("schoolExperienceId"));
				user.setCheckOut((String) map.get("checkOut"));
				user.setIsDeleted((String) map.get("isDeleted"));
				user.setClassNo((String) map.get("classNo"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for (User user : list) {
			System.out.println(user.getEmail() + " " + user.getTruename());
		}
	}
}

