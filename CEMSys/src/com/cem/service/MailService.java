package com.cem.service;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import com.cem.pojo.User;

public interface MailService {
	public void sendMail();
	
	//含有图片的mail 当图片为null时没有图片
	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException;
	
	public List<String> findUserEmailList(List<String> queryCondition);
	
	public List<String> generateQueryCondition(String toList,String what);//what表示是发送类型
	
	public void sendAuditSuccessMail(String userMail);
	
	public void sendBirthdayBlessMail(List<User> userList);
	
	
}
