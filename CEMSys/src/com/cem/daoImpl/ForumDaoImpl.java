package com.cem.daoImpl;

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
import com.cem.pojo.Reply;

@Repository
public class ForumDaoImpl implements ForumDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String insertForum(Forum forum) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(forum);
		return "succ";
	}

	@Override
	public String insertReply(Reply reply) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(reply);
		return "succ";
	}

	@Override
	public String deleteForum(int ForumId) {
		// TODO Auto-generated method stub
		String sql = "update forum set isDeleted='1' where forumId='"+ForumId+"'";
		int result = jdbcTemplate.update(sql);
		if (result > 0 ) {
			return "succ";
		}else{
			return "error";
		}
	}

	@Override
	public String deleteReply(int replyId) {
		// TODO Auto-generated method stub
		String sql = "update reply set isDeleted='1' where replyId='" + replyId+"'";
		int result = jdbcTemplate.update(sql);
		if (result > 0) {
			return "succ";
		}else {
			return "error";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> FindForumwhileGointoModule(int forumModuleId, int pageIndex) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Session session = getSession();
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		String sql = "select f from Forum f where f.forumModule=? and f.isDeleted='0' order by forumId desc";
		List<Forum> list = session.createQuery(sql).setString(0, String.valueOf(forumModuleId)).setFirstResult((pageIndex - 1)*32).list();
		String count = "select count(*) from Forum f where f.forumModule=? and f.isDeleted='0'";
		int count1 = Integer.parseInt(String.valueOf(session.createQuery(count).setString(0, String.valueOf(forumModuleId)).uniqueResult()));
		map.put("forumList", list);
		map.put("forumCount", count1);
		return map;
	}

	@Override
	public Map<String, Object> FindReplywhileGointoForum(int forumId, int pageIndex) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Session session = getSession();
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		String sql = "select r from Reply r where r.forum=? and r.isDeleted='0' order by replyTime asc";
		List<Reply> list = session.createQuery(sql).setString(0, String.valueOf(forumId)).setFirstResult((pageIndex-1)*32).list();
		String count = "select count(*) from Reply r where r.forum=? and r.isDeleted='0'";
		int count1 = Integer.parseInt(String.valueOf(session.createQuery(count).setString(0, String.valueOf(forumId)).uniqueResult()));
		map.put("replyList", list);
		map.put("replyCount", count1);
		return map;
	}

	@Override
	public String FindForumIdWhilePostForum(String userId, String publishTime) {
		// TODO Auto-generated method stub
		String sql = "select forumId from forum where userId='" + userId + "' and publishTime ='" + publishTime + "'";
		String forumId = jdbcTemplate.queryForObject(sql, String.class);
		return forumId;
	}

	@Override
	public Map<String, Object> FindForumByUserId(String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Session session = getSession();
		String sql = "select f from forum f where userId=? and isDeleted='0' order by forumId desc";
		String count = "select count(*) from f where userId=? and isDeleted='0'";
		List<Forum> list = session.createQuery(sql).setString(0, userId).list();
		int result = (int) session.createQuery(count).setString(0, userId).uniqueResult();
		map.put("forumList", list);
		map.put("count", result);
		return map;
	}

}
