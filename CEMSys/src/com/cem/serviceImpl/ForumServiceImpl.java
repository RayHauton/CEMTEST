package com.cem.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.ForumDao;
import com.cem.pojo.Forum;
import com.cem.pojo.ForumMessage;
import com.cem.pojo.Reply;
import com.cem.service.ForumService;
@Service
public class ForumServiceImpl implements ForumService{
	@Autowired
	private ForumDao forumDao;

	@Override
	public String insertForum(Forum forum) throws Exception {
		// TODO Auto-generated method stub
		return forumDao.insertForum(forum);
	}

	@Override
	public String insertReply(Reply reply, String forumId) {
		// TODO Auto-generated method stub
		return forumDao.insertReply(reply,forumId);
	}

	@Override
	public String deleteForum(int ForumId) {
		// TODO Auto-generated method stub
		return forumDao.deleteForum(ForumId);
	}

	@Override
	public String deleteReply(int replyId) {
		// TODO Auto-generated method stub
		return forumDao.deleteReply(replyId);
	}

	@Override
	public Map<String, Object> FindForumwhileGointoModule(int forumModuleId,int pageIndex) {
		// TODO Auto-generated method stub
		return forumDao.FindForumwhileGointoModule(forumModuleId,pageIndex);
	}

	@Override
	public Map<String, Object> FindReplywhileGointoForum(int forumId,int pageIndex) {
		// TODO Auto-generated method stub
		return forumDao.FindReplywhileGointoForum(forumId,pageIndex);
	}

	@Override
	public String FindForumIdWhilePostForum(String userId, String publishTime) {
		// TODO Auto-generated method stub
		return forumDao.FindForumIdWhilePostForum(userId, publishTime);
	}

	@Override
	public Map<String, Object> FindForumByUserId(String userId,String pageNum) {
		// TODO Auto-generated method stub
		return forumDao.FindForumByUserId(userId,pageNum);
	}

	@Override
	public Short getFloorWhenInsertReply(String forumId) {
		// TODO Auto-generated method stub
		return forumDao.getFloorWhenInsertReply(forumId);
	}

	@Override
	public void insertMessage(ForumMessage forumMessage) {
		// TODO Auto-generated method stub
		forumDao.insertMessage(forumMessage);
	}

	@Override
	public int findNewMessageNumber(int userId) {
		// TODO Auto-generated method stub
		return forumDao.findNewMessageNumber(userId);
	}

	@Override
	public Map<String, Object> FindAllNewMessages(int userId,String messagePageIndex) {
		// TODO Auto-generated method stub
		return forumDao.FindAllNewMessages(userId,messagePageIndex);
	}

	@Override
	public Map<String, Object> FindReplyByUserId(String userId,String pageNum) {
		// TODO Auto-generated method stub
		return forumDao.FindReplyByUserId(userId,pageNum);
	}

}
