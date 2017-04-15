package com.cem.service;

import java.util.Map;

import javax.mail.MessagingException;

public interface MailService {
	public void sendMail();
	
	public void testMail();
	
	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException;
}
