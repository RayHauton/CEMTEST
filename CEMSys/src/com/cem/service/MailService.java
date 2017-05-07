package com.cem.service;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

public interface MailService {
	public void sendMail();
	
	public void testMail();
	
	//含有图片的mail
	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException;
	
	public List<String> findUserEmailList(List<String> queryCondition);
	
	public List<String> generateQueryCondition(String toList,String what);
	
}
