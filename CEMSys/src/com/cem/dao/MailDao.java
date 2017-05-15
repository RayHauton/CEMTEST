package com.cem.dao;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import com.cem.pojo.HTMLMail;
import com.cem.pojo.User;

public interface MailDao {
	public void sendBirthdayMail();

	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException;

	public List<String> findUserEmailList(List<String> queryCondition);

	public List<String> generateQueryCondition(String toList, String what);
	
	public void sendAuditSuccessMail(String userMail);
	
	public void sendBirthdayBlessMail(List<User> userList);

	public void sendHyperTextMail(HTMLMail htmlMail) throws MessagingException;
}
