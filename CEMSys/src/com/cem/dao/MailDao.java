package com.cem.dao;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

public interface MailDao {
	public void sendBirthdayMail();

	public void testMail();

	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException;

	public List<String> findUserEmailList(List<String> queryCondition);

	public List<String> generateQueryCondition(String toList, String what);

}
