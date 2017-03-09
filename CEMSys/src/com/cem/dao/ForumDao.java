package com.cem.dao;

import java.util.Map;

import com.cem.pojo.Forum;
import com.cem.pojo.ForumMessage;
import com.cem.pojo.Reply;

public interface ForumDao {
	/**
	 * 发帖功能
	 * @throws Exception 
	 */
	public String insertForum(Forum forum) throws Exception;
	
	/**
	 * 回复功能
	 * @param forumId 
	 */
	public String insertReply(Reply reply, String forumId);
	
	/**
	 * 删除帖子功能
	 */
	public String deleteForum(int ForumId);
	
	/**
	 * 删除回复功能
	 */
	
	public String deleteReply(int replyId);

	/**
	 * 进入模块，根据模块id查找帖子
	 * 默认的一页帖子数是32
	 */
	public Map<String, Object> FindForumwhileGointoModule(int forumModuleId,int pageIndex);
	
	/**
	 * 进入帖子，根据帖子id展示楼层
	 * 默认的一页回复数是32
	 */
	public Map<String, Object> FindReplywhileGointoForum(int forumId,int pageIndex);
	
	/**
	 * 生成帖子的过程中，将楼主的内容置为1楼，需要得到帖子的id
	 */
	public String FindForumIdWhilePostForum(String userId,String publishTime);
	
	/**
	 * 根据用户id查找用户发的帖子,其他用户可以查看当前用户的帖子
	 */
	public Map<String, Object> FindForumByUserId(String userId);

	/**
	 * 根据用户id查找用户发的回复，其他用户可以查看
	 */
	public Map<String, Object> FindReplyByUserId(String userId);
	
	/**
	 * 回复时得到此次回复所在楼层
	 * @param forumId
	 * @return
	 */
	public Short getFloorWhenInsertReply(String forumId);
	
	/**
	 * 消息提醒 插入到forumMessage表中
	 */
	public void insertMessage(ForumMessage forumMessage);
	
	/**
	 * 新消息数目
	 * @return 
	 */
	public int findNewMessageNumber(int userId);
	
	/**
	 * 查看新消息同时全部置为已读
	 */
	public Map<String,Object> FindAllNewMessages(int userId,String messagePageIndex);
}