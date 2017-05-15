package com.cem.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.MailDao;
import com.cem.pojo.HTMLMail;
import com.cem.pojo.User;
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
	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException {
		// TODO Auto-generated method stub
		mailDao.sendHyperTextMail(subject, content, toList, pictures, attachments);
	}

	@Override
	public List<String> findUserEmailList(List<String> queryCondition) {
		// TODO Auto-generated method stub
		return mailDao.findUserEmailList(queryCondition);
	}

	@Override
	public List<String> generateQueryCondition(String toList, String what) {
		// TODO Auto-generated method stub
		return mailDao.generateQueryCondition(toList, what);
	}

	@Override
	public void sendAuditSuccessMail(String userMail) {
		// TODO Auto-generated method stub
		mailDao.sendAuditSuccessMail(userMail);
	}

	@Override
	public void sendBirthdayBlessMail(List<User> userList) {
		// TODO Auto-generated method stub
		mailDao.sendBirthdayBlessMail(userList);
	}

	@Override
	public void sendHyperTextMail(HTMLMail htmlMail) {
		// TODO Auto-generated method stub
		try {
			mailDao.sendHyperTextMail(htmlMail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
