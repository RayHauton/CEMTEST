package com.cem.service;

import java.util.List;
import java.util.Map;

import com.cem.pojo.Forum;
import com.cem.pojo.Reply;

public interface ForumService {
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
	 * 根据用户id查找用户发的说说,其他用户可以查看当前用户的说说
	 */
	public Map<String, Object> FindForumByUserId(String userId);

	/**
	 * 回复时得到回复的楼层
	 * @param forumId
	 * @return
	 */
	public Short getFloorWhenInsertReply(String forumId);
}
