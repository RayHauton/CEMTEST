package com.cem.daoImpl;

import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

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
	 * 所有页面默认显示条数大小为32
	 * 可根据情况进行修改
	 * 可能不同页面显示不同 没有全局变量pageSize
	 * crtl+f 检索 pageSize
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
		String sql = "update Forum set replyCount=replyCount+1 where forumId='" + forumId + "'";
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
		int pageSize = 5;
		Session session = getSession();
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		String sql = "select f from Forum f where f.forumModule=? and f.isDeleted='0' order by forumId desc";
		List<Forum> list = session.createQuery(sql).setString(0, String.valueOf(forumModuleId))
				.setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
		String count = "select count(*) from Forum f where f.forumModule=? and f.isDeleted='0'";
		int count1 = Integer.parseInt(
				String.valueOf(session.createQuery(count).setString(0, String.valueOf(forumModuleId)).uniqueResult()));
		int forumPage = count1 > pageSize ? (count1 / pageSize) + 1 : 1;
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
		int pageSize = 5;
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
		int replyPage = count1 > pageSize ? (count1 / pageSize) + 1 : 1;
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

	@Override
	public Map<String, Object> FindForumByUserId(String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Session session = getSession();
		String sql = "select f from Forum f where userId=? and isDeleted='0' order by forumId desc";
		String count = "select count(*) from Forum  where userId=? and isDeleted='0'";
		List<Forum> list = session.createQuery(sql).setString(0, userId).list();
		int result = (int) session.createQuery(count).setString(0, userId).uniqueResult();
		map.put("forumList", list);
		map.put("count", result);
		return map;
	}

	@SuppressWarnings("deprecation")
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
	public Map<String, Object> FindReplyByUserId(String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Session session = getSession();
		String sql = "select * from Reply where userId=? and isDeleted='0' order by replyId desc";
		String count = "select count(*) from Reply where userId=? and isDeleted='0' ";
		List<Reply> list = session.createQuery(sql).setString(0, userId).list();
		int result = (int) session.createQuery(count).setString(0, userId).uniqueResult();
		map.put("replyList", list);
		map.put("count", result);

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
		//1
//		Session session = getSession();
//		String sql = "select count(*) from ForumMessage where personId=? and status='0' ";
//		int count = Integer
//				.parseInt(String.valueOf(session.createQuery(sql).setString(0, String.valueOf(userId)).uniqueResult()));
		//2 which is better? i dont know sry,but i prefer 2.
		String sql = "select count(*) from ForumMessage where personId='"+userId +"' and status='0' ";
		int count = Integer.parseInt(jdbcTemplate.queryForObject(sql, String.class));
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> FindAllNewMessages(int userId,String messagePageIndex) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		int pageSize = 5;
		Session session = getSession();
		String sql = "select f from ForumMessage f where personId=? order by id desc";
		List<ForumMessage> list = session.createQuery(sql).setString(0, String.valueOf(userId)).setMaxResults(pageSize).setFirstResult((Integer.parseInt(messagePageIndex)-1)*pageSize).list();
		map.put("messageList", list);
		String changeStatus = "update ForumMessage set status='1' where personId=?";
		session.createQuery(changeStatus).setInteger(0, userId).executeUpdate();
		return map;
	}
}
