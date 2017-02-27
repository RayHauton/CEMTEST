package com.cem.test;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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
	
	@Test
	public void tets(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUtil.getBean(JdbcTemplate.class);
		String sql = "select max(floor)+1 from Reply r where r.forum='13'";
		String result = jdbcTemplate.queryForObject(sql, String.class);
		System.out.println(result);
	}
}

