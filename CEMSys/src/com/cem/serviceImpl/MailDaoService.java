package com.cem.serviceImpl;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cem.dao.MailDao;
import com.cem.service.MailService;

@Service
public class MailDaoService implements MailService {

	@Override
//	@Scheduled(cron = "0/10 * * * * ?") // 间隔5秒执行
	public void sendMail() {
		// TODO Auto-generated method stub
		System.out.println("定时的任务");
	}

	@Override
	public void testMail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException {
		// TODO Auto-generated method stub
		
	}

}
