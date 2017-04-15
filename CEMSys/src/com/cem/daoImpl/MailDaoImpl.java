package com.cem.daoImpl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.cem.dao.MailDao;
import com.cem.pojo.User;
@Repository
public class MailDaoImpl implements MailDao{
	@Autowired
	private DataSource dataSource;
	
	private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	
	private Properties prop = new Properties();
	
	private String Username = "nuaadadan@163.com";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
//	@Scheduled(cron="0 0 9 * * ?")//每天上午9点执行
	public void sendBirthdayMail() {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(new Date());
		//遍历得到当天生日的校友
		String sql = "select * from user where DATEDIFF('"+ today +"',birth) = 0";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List<User> userList = new ArrayList<>();
		for(Map<String, Object> map:list){
			User user = translateMapToUser(map);
			userList.add(user);
		}
	}

	public void initMailSender(){
		mailSender.setHost("smtp.163.com");
		mailSender.setUsername("nuaadadan@163.com");
		mailSender.setPassword("dadan123");	
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.timeout", "25000");
		mailSender.setJavaMailProperties(prop);
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
	
	@Override
	public void sendHyperTextMail(String subject,String content,String[] toList,Map<String, String> pictures,Map<String, String> attachments) throws MessagingException{
		initMailSender();
		MimeMessage mailMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
		messageHelper.setFrom(Username);//设置发件人邮箱
		
		//设置收件人邮箱
		if (toList.length <= 0) {
			throw new RuntimeException("收件人邮箱不得为空");
		}
		messageHelper.setTo(toList);
		messageHelper.setSubject(subject);//设置主题
		messageHelper.setText(content, true);//true表示启动HTML格式的邮件
		
		//添加图片
		if (pictures!=null) {
			for(Iterator<Map.Entry<String, String>> it = pictures.entrySet().iterator();it.hasNext();){
				Map.Entry<String, String> entry = it.next();
				String cid = entry.getKey();
				String filePath = entry.getValue();
				if (null == cid || null == filePath) {  
                    throw new RuntimeException("请确认每张图片的ID和图片地址是否齐全！");  
                }
				
				File file = new File(filePath);
//				if (!file.exists()) {
//					throw new RuntimeException("图片"+ filePath+"不存在");
//				}
				FileSystemResource img = new FileSystemResource(file);
				messageHelper.addInline(cid, img);
			}
		}
		
		// 添加附件  
        if (null != attachments) {  
            for (Iterator<Map.Entry<String, String>> it = attachments  
                    .entrySet().iterator(); it.hasNext();) {  
                Map.Entry<String, String> entry = it.next();  
                String cid = entry.getKey();  
                String filePath = entry.getValue();  
                if (null == cid || null == filePath) {  
                    throw new RuntimeException("请确认每个附件的ID和地址是否齐全！");  
                }  
  
                File file = new File(filePath);  
                if (!file.exists()) {  
                    throw new RuntimeException("附件" + filePath + "不存在！");  
                }  
  
                FileSystemResource fileResource = new FileSystemResource(file);  
                messageHelper.addAttachment(cid, fileResource);  
            }  
        }
        
        //发送邮件
        try {
        	mailSender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
        System.out.println(1);
	}
	
	public User translateMapToUser(Map<String, Object> map){
		User user= new User();
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
		return user;
	}
	
	
}
