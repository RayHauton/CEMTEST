package com.cem.daoImpl;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Repository;

import com.cem.dao.MailDao;
@Repository
public class MailDaoImpl implements MailDao{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	private Properties prop = new Properties();
	
	@Override
	public void sendBirthdayMail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testMail() {
		// TODO Auto-generated method stub
		initMailSender();
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mailSender.getUsername());
		simpleMailMessage.setTo("987612820@qq.com");
		simpleMailMessage.setSubject("This is a test");
		simpleMailMessage.setText("dadan");
		
		mailSender.send(simpleMailMessage);
	}
	
	public void initMailSender(){
		mailSender.setHost("smtp.163.com");
		mailSender.setUsername("nuaadadan@163.com");
		mailSender.setPassword("dadan123");	
		prop.setProperty("mail.smtp.auth", "true");
		prop.put("mail.smtp.timeout", 5000);
		mailSender.setJavaMailProperties(prop);
	}
	
	//富文本编辑
	public void muchMailSender(){
		
	}
}
