package com.cem.dao;

import java.util.Map;

import javax.mail.MessagingException;

public interface MailDao {
	public void sendBirthdayMail();

	public void testMail();

	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException;
	
}
