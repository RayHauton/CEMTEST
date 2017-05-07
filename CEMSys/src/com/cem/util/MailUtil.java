package com.cem.util;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtil {
	private String host;
	private String userFrom;
	private String username;
	private String password;
	private static Properties prop;
	private static JavaMailSenderImpl sender;
	private static MimeMessage mailMessage;
	private static MimeMessageHelper messageHelper;
	static {
		try {
			sender = new JavaMailSenderImpl();
			mailMessage = sender.createMimeMessage();
			messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			prop = new Properties();
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.timeout", "25000");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param userTo
	 *            接收方
	 * @param subject
	 *            主题
	 * @param textContext
	 *            文字内容
	 * @param file
	 *            附件
	 * @throws MessagingException
	 */
	public void sendMail(String[] userTo, String subject, String textContext, File file) throws MessagingException {
		// 设置邮件服务器
		sender.setHost(host);
		messageHelper.setTo(userTo);
		messageHelper.setFrom(userFrom);
		messageHelper.setSubject(subject);
		messageHelper.setText(textContext);
//		if(file!=null){
//			FileSystemResource fileSystemResource = new FileSystemResource(file);
//			messageHelper.addAttachment("test.rar", fileSystemResource);
//		}
		sender.setUsername(username);
		sender.setPassword(password);
		sender.setJavaMailProperties(prop);
		// 发送邮件
		sender.send(mailMessage);
		System.out.println("发送成功");
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
