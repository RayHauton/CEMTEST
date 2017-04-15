package com.cem.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cem.dao.MailDao;
import com.cem.pojo.User;
import com.cem.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MailDao mailDao;
	@Override
//	@Scheduled(cron = "0/10 * * * * ?") // 间隔10秒执行
	@Scheduled(cron="0 0 9 * * ?")//每天上午九点执行
	public void sendMail() {
		// TODO Auto-generated method stub
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = sFormat.format(new Date());
		//遍历得到e-mail和birthday
		String sql = "select * from user where DATEDIFF('2017-04-09',birth) = 0";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List<User> userlist = new ArrayList<>();
		for (Map<String, Object> map : list) {
			User user2 = translateMapToUser(map);
			userlist.add(user2);
		}
		
	}
	
	public User translateMapToUser(Map<String, Object> map){
		User user = new User();
		user.setUserId((int) map.get("userId"));
		user.setUsername((String) map.get("username"));
		user.setTruename((String) map.get("truename"));
		user.setSex((String) map.get("sex"));
		user.setStudNumber((String) map.get("studNumber"));
		user.setBirth((String) map.get("birth"));
		user.setMobile((String) map.get("mobile"));
		user.setEmail((String) map.get("email"));
		user.setEntranceDate((String) map.get("entranceDate"));
		user.setGraduateDate((String) map.get("graduateDate"));
		user.setSchoolExperienceId((String) map.get("schoolExperienceId"));
		user.setCheckOut((String) map.get("checkOut"));
		user.setIsDeleted((String) map.get("isDeleted"));
		user.setClassNo((String) map.get("classNo"));
		return user;
	}

	@Override
	public void testMail() {
		// TODO Auto-generated method stub
		
	}

}
