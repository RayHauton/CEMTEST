package com.cem.serviceImpl;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.MailDao;
import com.cem.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private MailDao mailDao;
	
	@Override
//	@Scheduled(cron = "0/10 * * * * ?") // 间隔5秒执行
	public void sendMail() {
		// TODO Auto-generated method stub
		mailDao.sendBirthdayMail();
	}
	
	@Override
	public void testMail(){
		mailDao.testMail();
	}

	@Override
	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException {
		// TODO Auto-generated method stub
		mailDao.sendHyperTextMail(subject, content, toList, pictures, attachments);
	}

}
