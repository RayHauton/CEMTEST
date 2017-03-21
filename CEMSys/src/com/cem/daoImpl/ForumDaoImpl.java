package com.cem.daoImpl;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cem.dao.ForumDao;
import com.cem.pojo.Forum;
import com.cem.pojo.ForumMessage;
import com.cem.pojo.Reply;

@Repository
public class ForumDaoImpl implements ForumDao {
	/**
	 * 所有页面默认显示条数大小为5 可根据情况进行修改 可能不同页面显示不同 没有全局变量pageSize crtl+f 检索 pageSize
	 */

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String insertForum(Forum forum) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		forum.setIsDeleted("0");
		forum.setIsFine("0");
		forum.setViewCount(1);
		forum.setReplyCount(0);
		session.save(forum);
		return "succ";
	}

	@Override
	public String insertReply(Reply reply, String forumId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		reply.setIsDeleted("0");
		String sql = "update Forum set replyCount=replyCount+1,updateTime ='" + reply.getReplyTime()
				+ "' where forumId='" + forumId + "'";
		jdbcTemplate.update(sql);
		session.save(reply);
		return "succ";
	}

	@Override
	public String deleteForum(int ForumId) {
		// TODO Auto-generated method stub
		String sql = "update Forum set isDeleted='1' where forumId='" + ForumId + "'";
		int result = jdbcTemplate.update(sql);
		if (result > 0) {
			return "succ";
		} else {
			return "error";
		}
	}

	@Override
	public String deleteReply(int replyId) {
		// TODO Auto-generated method stub
		String sql = "update Reply set isDeleted='1' where replyId='" + replyId + "'";
		int result = jdbcTemplate.update(sql);
		if (result > 0) {
			return "succ";
		} else {
			return "error";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> FindForumwhileGointoModule(int forumModuleId, int pageIndex) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Date date = new Date();
		int pageSize = 10;
		Session session = getSession();
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		String sql = "select f from Forum f where f.forumModule=? and f.isDeleted='0' order by updateTime desc";
		List<Forum> list = session.createQuery(sql).setString(0, String.valueOf(forumModuleId))
				.setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
		String count = "select count(*) from Forum f where f.forumModule=? and f.isDeleted='0'";
		int count1 = Integer.parseInt(
				String.valueOf(session.createQuery(count).setString(0, String.valueOf(forumModuleId)).uniqueResult()));
		int forumPage = count1 % pageSize==0 ? (count1 / pageSize) : (count1 / pageSize) + 1;
		try {
			for (Forum forum : list) {
				forum.setPublishTime(getFriendlyTime(forum.getPublishTime()));
				forum.setUpdateTime(getFriendlyTime(forum.getUpdateTime()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		map.put("forumModule", forumModuleId);
		map.put("forumList", list);// forum列表
		map.put("forumCount", count1);// 一共多少个帖子
		map.put("currentForumPage", pageIndex);// 当前所在页面
		map.put("totalForumPage", forumPage);// 总页面数
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> FindReplywhileGointoForum(int forumId, int pageIndex) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		List<Reply> objectReplyList = new ArrayList<>();
		int pageSize = 10;
		Session session = getSession();
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		String sql = "select r from Reply r where r.forum=? and r.isDeleted='0' order by replyTime asc";
		List<Reply> list = session.createQuery(sql).setString(0, String.valueOf(forumId))
				.setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
		String count = "select count(*) from Reply r where r.forum=? and r.isDeleted='0'";
		int count1 = Integer.parseInt(
				String.valueOf(session.createQuery(count).setString(0, String.valueOf(forumId)).uniqueResult()));
		String sql2 = "select f from Forum f where f.forumId=?";
		Forum forum = (Forum) session.createQuery(sql2).setString(0, String.valueOf(forumId)).uniqueResult();
		forum.setViewCount(forum.getViewCount() + 1);
		String sql3 = "update Forum set viewCount = viewCount+1 where forumId='" + forumId + "'";
		jdbcTemplate.update(sql3);
		int replyPage = count1 % pageSize == 0 ? (count1 / pageSize) : (count1 / pageSize) + 1;
		try {
			for (Reply reply : list) {
				reply.setReplyTime(getFriendlyTime(reply.getReplyTime()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		map.put("replyList", list);// reply列表
		map.put("totalReplyPage", replyPage);// 总的回复页数
		map.put("thisForum", forum);// 所在的forum信息
		map.put("currentReplyPage", pageIndex);// 当前回复页面数
		return map;
	}

	@Override
	public String FindForumIdWhilePostForum(String userId, String publishTime) {
		// TODO Auto-generated method stub
		String sql = "select forumId from forum where userId='" + userId + "' and publishTime ='" + publishTime + "'";
		// String forumId = String.valueOf(jdbcTemplate.queryForObject(sql,
		// int.class));
		String forumId = jdbcTemplate.queryForObject(sql, String.class);
		return forumId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> FindForumByUserId(String userId, String pageNum) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Session session = getSession();
		int pageSize = 10;
		String sql = "select f from Forum f where userId=? and isDeleted='0' order by forumId desc";
		String count = "select count(*) from Forum  where userId=? and isDeleted='0'";
		List<Forum> list = session.createQuery(sql).setString(0, userId)
				.setFirstResult((Integer.parseInt(pageNum) - 1) * pageSize).setMaxResults(pageSize).list();
		int result = Integer.parseInt(String.valueOf(session.createQuery(count).setString(0, userId).uniqueResult()));
		int totalPage = result%pageSize==0? result/pageSize:result/pageSize+1;
		try {
			for (Forum forum : list) {
				forum.setPublishTime(getFriendlyTime(forum.getPublishTime()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		map.put("forumList", list);
		map.put("count", result);
		map.put("totalPage", totalPage);
		map.put("currentUserId", userId);
		map.put("currentPageNum", pageNum);
		return map;
	}

	@Override
	public Short getFloorWhenInsertReply(String forumId) {
		// TODO Auto-generated method stub
		String sql = "select max(floor)+1 from Reply r where r.forum='" + forumId + "'";
		String result = jdbcTemplate.queryForObject(sql, String.class);
		short floor = (short) Integer.parseInt(result);
		return floor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> FindReplyByUserId(String userId, String pageNum) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Session session = getSession();
		int pageSize = 10;
		String sql = "select r from Reply r where publishUserId=? and isDeleted='0' order by replyId desc";
		String count = "select count(*) from Reply where publishUserId=? and isDeleted='0' ";
		List<Reply> list = session.createQuery(sql).setString(0, userId).setFirstResult((Integer.parseInt(pageNum)-1)*pageSize).setMaxResults(pageSize).list();
		int result = Integer.parseInt(String.valueOf(session.createQuery(count).setString(0, userId).uniqueResult()));
		int totalPage = result%pageSize==0?result/pageSize:result/pageSize+1;
		try {
			for (Reply reply : list) {
				reply.setReplyTime(getFriendlyTime(reply.getReplyTime()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		map.put("replyList", list);
		map.put("count", result);
		map.put("totalPage", totalPage);
		map.put("currentUserId", userId);
		map.put("currentPageNum", pageNum);
		return map;
	}

	@Override
	public void insertMessage(ForumMessage forumMessage) {
		// TODO Auto-generated method stub
		Session session = getSession();
		forumMessage.setStatus("0");
		session.save(forumMessage);
	}

	@Override
	public int findNewMessageNumber(int userId) {
		// TODO Auto-generated method stub
		// 1
		// Session session = getSession();
		// String sql = "select count(*) from ForumMessage where personId=? and
		// status='0' ";
		// int count = Integer
		// .parseInt(String.valueOf(session.createQuery(sql).setString(0,
		// String.valueOf(userId)).uniqueResult()));
		// 2 which is better? i dont know sry,but i prefer 2.
		String sql = "select count(*) from ForumMessage where objectReplyId='" + userId + "' and status='0' and personId <> '" + userId +"'";
		int count = Integer.parseInt(jdbcTemplate.queryForObject(sql, String.class));
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> FindAllNewMessages(int userId, String messagePageIndex) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		int pageSize = 10;
		Session session = getSession();
		String sql = "select f from ForumMessage f where objectReplyId=? and personId <> ? order by id desc";
		List<ForumMessage> list = session.createQuery(sql).setString(0, String.valueOf(userId)).setString(1, String.valueOf(userId)).setMaxResults(pageSize)
				.setFirstResult((Integer.parseInt(messagePageIndex) - 1) * pageSize).list();
		for (ForumMessage forumMessage : list) {
			try {
				forumMessage.setTime(getFriendlyTime(forumMessage.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		map.put("messageList", list);
		map.put("currentPageNum", messagePageIndex);
		updateMessageInfo(userId);
		return map;
	}

	public void updateMessageInfo(int userId){
		String changeStatus = "update ForumMessage set status='1' where personId='"+userId+"'";
		jdbcTemplate.update(changeStatus);
	}
	public String getFriendlyTime(String date) throws ParseException {
		Date nowTime = new Date();
		Date oldtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
		// //精确到哪一个时间点
		long ys = DateUtils.truncate(nowTime, Calendar.YEAR).getTime();// 当前时间精确到年
		long ds = DateUtils.truncate(nowTime, Calendar.DAY_OF_MONTH).getTime();// 当前时间精确到日
		long yd = DateUtils.truncate(oldtime, Calendar.DAY_OF_MONTH).getTime();// 转换时间精确到日

		long n = nowTime.getTime();
		long e = oldtime.getTime();
		if (e < ys) {// 时间转换成y-m-d//去年以前的
			return new SimpleDateFormat("yyyy-MM-dd").format(oldtime);
		}
		if ((ds - yd) == (24 * 60 * 60 * 1000)) {// 24h内
			return new SimpleDateFormat("昨天 HH:mm").format(oldtime);
		}
		if (e < ds) {// 今天以前的信息
			String result = new SimpleDateFormat("MM-dd").format(oldtime);
			if (result.substring(0, 1).equals("0")) {
				result = result.substring(1, 5);
			}
			return result;
		}
		if (n - e > 60 * 60 * 1000) {// 一小时之前的
			String result = new SimpleDateFormat("HH:mm").format(oldtime);
			return "今天" + result;
		}
		if (n - e > 60 * 1000) {
			// 1d 是double 自动转换
			return (long) Math.floor((n - e) * 1d / 60000) + "分钟前";
		}
		if (n - e > 1 * 1000) {
			return "刚刚";
		}
		return date;
	}
}
