package com.cem.daoImpl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadPoolExecutor;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.apache.commons.net.smtp.SMTP;
import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Repository;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import com.cem.dao.MailDao;
import com.cem.pojo.HTMLMail;
import com.cem.pojo.User;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import com.sun.mail.handlers.text_html;
import com.sun.media.jfxmedia.logging.Logger;

import sun.net.smtp.SmtpClient;

@Repository
public class MailDaoImpl implements MailDao {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private SessionFactory sessionFactory;

	@Value("${mail.username}")
	private String userName;

	@Value("${mail.password}")
	private String password;

	@Value("${mail.host}")
	private String host;

	private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	private Properties prop = new Properties();

	private ThreadPoolTaskExecutor _threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	// @Scheduled(cron = "0 0 9 * * ?") // 每天上午9点执行
	// @Scheduled(cron="0/20 * * * * ?")//每隔x秒执行一次
	public void sendBirthdayMail() {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(new Date());
		// 遍历得到当天生日的校友
		// String sql = "select * from user where DATEDIFF('" + today +
		// "',birth) = 0";
		// 将所有的日期转换成2000年进行比较
		String sql = "select * from user where DATEDIFF(CONCAT('2000',DATE_FORMAT('" + today
				+ "','-%m-%d')),CONCAT('2000',DATE_FORMAT(birth,'-%m-%d')))='0'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() == 0) {
			System.out.println("无人今日生日");
		} else {
			System.out.println("今天" + list.size() + "人生日");
			List<User> userList = new ArrayList<>();
			for (Map<String, Object> map : list) {
				User user = translateMapToUser(map);
				userList.add(user);
			}
			sendBirthdayBlessMail(userList);
		}
	}

	public void initMailSender() {
		mailSender.setHost(host);
		mailSender.setUsername(userName);
		mailSender.setPassword(password);
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.timeout", "25000");
		mailSender.setJavaMailProperties(prop);
	}

	@Override
	public void sendHyperTextMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) throws MessagingException {
		initMailSender();
		MimeMessage mailMessage = mailSender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
		messageHelper.setFrom(userName);// 设置发件人邮箱

		// 设置收件人邮箱
		if (toList.length <= 0) {
			throw new RuntimeException("收件人邮箱不得为空");
		}
		messageHelper.setTo(toList);
		messageHelper.setSubject(subject);// 设置主题
		messageHelper.setText(content, true);// true表示启动HTML格式的邮件

		// 添加图片
		if (pictures != null) {
			for (Iterator<Map.Entry<String, String>> it = pictures.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = it.next();
				String cid = entry.getKey();
				String filePath = entry.getValue();
				if (null == cid || null == filePath) {
					throw new RuntimeException("请确认每张图片的ID和图片地址是否齐全！");
				}
				File file = new File(filePath);
				// if (!file.exists()) {
				// throw new RuntimeException("图片"+ filePath+"不存在");
				// }
				FileSystemResource img = new FileSystemResource(file);
				messageHelper.addInline(cid, img);
			}
		}

		// 添加附件
		if (null != attachments) {
			for (Iterator<Map.Entry<String, String>> it = attachments.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = it.next();
				String cid = entry.getKey();
				String filePath = entry.getValue();
				if (null == cid || null == filePath) {
					throw new RuntimeException("请确认每个附件的ID和地址是否齐全！");
				}

				File file = new File(filePath);
				if (!file.exists()) {
					throw new RuntimeException("附件" + filePath + "不存在！");
				}

				FileSystemResource fileResource = new FileSystemResource(file);
				messageHelper.addAttachment(cid, fileResource);
			}
		}

		// 发送邮件
		// 同步发送
		long time1 = System.currentTimeMillis();
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		long time2 = System.currentTimeMillis();
		// 异步发送
		_threadPoolTaskExecutor = initThreadPoolExecutor();
		_threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					mailSender.send(mailMessage);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		long time3 = System.currentTimeMillis();

		System.err.println("同步完成时间：" + (time2 - time1));
		System.err.println("异步完成时间：" + (time3 - time2));
	}

	public User translateMapToUser(Map<String, Object> map) {
		User user = new User();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findUserEmailList(List<String> queryCondition) {
		// TODO Auto-generated method stub
		List<String> userList = new ArrayList<>();
		String sql = null;
		Session session = sessionFactory.getCurrentSession();
		if (queryCondition == null) {
			return null;
		} else if (queryCondition.size() == 1 && queryCondition.get(0) == "allUsers") {
			sql = "select email from User";
			userList = session.createQuery(sql).list();
		} else {
			for (String condition : queryCondition) {
				sql = "select email from User where classNo LIKE '" + condition + "'";
				List<String> tempList = session.createQuery(sql).list();
				userList.addAll(tempList);
			}
		}
		return userList;
	}

	@Override
	public List<String> generateQueryCondition(String toList, String what) {
		// TODO Auto-generated method stub
		List<String> queryCondition = new ArrayList<>();
		String[] strArr = null;
		String regex = ",|，";// 中文或者英文逗号
		if (toList.contains(",") || toList.contains("，")) {
			strArr = toList.split(regex);
		} else {
			strArr = new String[1];
			strArr[0] = toList;
		}
		if (what.equals("allUsers")) {
			queryCondition.add("allUsers");
		} else if (what.equals("grade")) {// 按年级
			for (String s : strArr) {
				// 09+年级+%
				queryCondition.add("09" + s + "%");
			}
		} else if (what.equals("dept")) {// 按专业
			for (String s : strArr) {
				// 09+__+专业号码+%
				queryCondition.add("09__" + s + "%");
			}
		} else if (what.equals("class")) {// 按班级
			for (String s : strArr) {
				// 09+班级号码
				queryCondition.add("09" + s);
			}
		} else {
			return null;
		}
		System.out.println(queryCondition);
		return queryCondition;
	}

	@Override
	public void sendAuditSuccessMail(String userMail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendBirthdayBlessMail(List<User> userList) {
		// TODO Auto-generated method stub
		initMailSender();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(new Date());
		String subject = "南航大经管院全体祝您生日快乐";
		StringBuffer content = null;
		if (userList == null) {
			System.out.println("今日无人生日");
		} else {
			for (User usr : userList) {
				content = new StringBuffer("<p>");
				content.append(usr.getTruename()
						+ "：</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 您好！</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 今天是"
						+ today
						+ "，您之前在南京航空航天大学经济与管理学院校友系统登记过您的生日。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;祝生日快乐，工作愉快，身体健康！</p><p style='text-align: right; '>南京航空航天大学经济与管理学院</p><p style='text-align: right; '>"
						+ today + "</p>");
				try {
					sendHyperTextMail(subject, content.toString(), new String[] { usr.getEmail() }, null, null);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public ThreadPoolTaskExecutor initThreadPoolExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setQueueCapacity(200); // 队列容量
		threadPoolTaskExecutor.setCorePoolSize(5); // 核心线程数量
		threadPoolTaskExecutor.setMaxPoolSize(100); // 最大线程数量
		threadPoolTaskExecutor.setKeepAliveSeconds(300); // 允许线程空闲时间
		threadPoolTaskExecutor.initialize(); // 重新初始化
		return threadPoolTaskExecutor;
	}

	public boolean isValid(String email) {
		if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			return false;
		}
		Record[] rsult = null;
		SMTPClient client = new SMTPClient();
		try {
			client.connect(host);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void sendHyperTextMail(HTMLMail htmlMail) throws MessagingException {
		// TODO Auto-generated method stub
		initMailSender();
		MimeMessage mailMessage = mailSender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
		messageHelper.setFrom(userName);// 设置发件人邮箱

		// 设置收件人邮箱
		if (htmlMail.getToList().length <= 0) {
			throw new RuntimeException("收件人邮箱不得为空");
		}
		messageHelper.setSubject(htmlMail.getSubject());// 设置主题
		messageHelper.setText(htmlMail.getContent(), true);// true表示启动HTML格式的邮件

		Map<String, String> pictures = htmlMail.getPictures();
		Map<String, String> attachments = htmlMail.getAttachments();
		// 添加图片
		if (pictures != null) {
			for (Iterator<Map.Entry<String, String>> it = pictures.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = it.next();
				String cid = entry.getKey();
				String filePath = entry.getValue();
				if (null == cid || null == filePath) {
					throw new RuntimeException("请确认每张图片的ID和图片地址是否齐全！");
				}
				File file = new File(filePath);
				// if (!file.exists()) {
				// throw new RuntimeException("图片"+ filePath+"不存在");
				// }
				FileSystemResource img = new FileSystemResource(file);
				messageHelper.addInline(cid, img);
			}
		}

		// 添加附件
		if (null != attachments) {
			for (Iterator<Map.Entry<String, String>> it = attachments.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = it.next();
				String cid = entry.getKey();
				String filePath = entry.getValue();
				if (null == cid || null == filePath) {
					throw new RuntimeException("请确认每个附件的ID和地址是否齐全！");
				}

				File file = new File(filePath);
				if (!file.exists()) {
					throw new RuntimeException("附件" + filePath + "不存在！");
				}

				FileSystemResource fileResource = new FileSystemResource(file);
				messageHelper.addAttachment(cid, fileResource);
			}
		}

		// 发送邮件
		_threadPoolTaskExecutor = initThreadPoolExecutor();
		long time2 = System.currentTimeMillis();
		_threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (String s1 : htmlMail.getToList()) {
					try {
						if (isValid_Email(s1)) {
							messageHelper.setTo(s1);
							mailSender.send(mailMessage);	
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		});
		long time3 = System.currentTimeMillis();
		System.err.println("异步完成时间：" + (time3 - time2));
	}
	
	//防止因为一个邮箱无效 导致不能发送邮件
	//进行邮箱的有效性检验
	public boolean isValid_Email(String email){
		if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			return false;
		}
		String host1111 = "";
		String hostName = email.split("@")[1];
		Record[] result = null;
		SMTPClient client = new SMTPClient();
		try {
			// 查找MX记录
			Lookup lookup = new Lookup(hostName, Type.MX);
			lookup.run();
			if (lookup.getResult() != Lookup.SUCCESSFUL) {
				return false;
			} else {
				result = lookup.getAnswers();
			}
			// 连接到邮箱服务器
			for (int i = 0; i < result.length; i++) {
				host1111 = result[i].getAdditionalName().toString();
				client.connect(host1111);
				if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
					client.disconnect();
					continue;
				} else {
					break;
				}
			}
			client.login("163.com");/////////////////////////////////////////此处要修改成发送方所在的位置
			client.setSender(userName);
			client.addRecipient(email);
			if (250 == client.getReplyCode()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try{
				client.disconnect();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return false;
	}
}
