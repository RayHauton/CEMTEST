package com.cem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cem.pojo.Forum;
import com.cem.pojo.ForumMessage;
import com.cem.pojo.Reply;
import com.cem.pojo.User;
import com.cem.service.ForumService;

@Controller
@RequestMapping(value="/forum")
public class ForumController {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ForumService forumService;
	
	private String getFormattedTime(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}
	/**
	 * 选择一个模块进入 得到帖子列表
	 * @param request
	 * @param response
	 * @param session
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/f/{forumModuleId}")
	private ModelAndView getForumList(HttpServletRequest request,HttpServletResponse response,HttpSession session,@PathVariable(value="forumModuleId") int id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		String pageNum = request.getParameter("forumIndex");
		if (pageNum == null) {
			pageNum = "1";
		}
		int pageIndex = Integer.parseInt(pageNum);
		session.setAttribute("forumModuleId", id);
		Map<String, Object> map = forumService.FindForumwhileGointoModule(id, pageIndex);
		modelAndView.setViewName("/baseView/bbsforum");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
	
	/**
	 * 点击帖子得到回复列表
	 * @param request
	 * @param response
	 * @param session
	 * @param forumId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/p/{forumId}")
	private ModelAndView getReplyList(HttpServletRequest request,HttpServletResponse response,HttpSession session,@PathVariable(value="forumId") int forumId) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		Map<String, Object> map = forumService.FindReplywhileGointoForum(forumId, Integer.parseInt(pageNum));
		modelAndView.addAllObjects(map);
		modelAndView.setViewName("/baseView/bbstest4css");
		return modelAndView;
	}
	
	/**
	 * 发帖
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertForum")
	private String insertForum(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		User user = (User) session.getAttribute("user");
		Forum forum = new Forum();
		Reply reply = new Reply();
		String forumTitle = request.getParameter("forumTitle");
		String content = request.getParameter("forumContent");
		if (content == null) {
			content = forumTitle;
		}
		String forumModuleId = String.valueOf(session.getAttribute("forumModuleId"));
		
		//对forum进行设置
		forum.setForumTitle(forumTitle);
		forum.setForumContent(content);
		forum.setPublishTime(getFormattedTime(new Date()));
		forum.setUpdateTime(forum.getPublishTime());
		forum.setUserId(user.getUserId());
		forum.setUsername(user.getUsername());
		forum.setForumModule(forumModuleId);
		forum.setTruename(user.getTruename());
		forumService.insertForum(forum);
		
		//同时将发帖内容发送到回复表中 （BBS格式）
		reply.setFloor((short) 1);
		String forumId = forumService.FindForumIdWhilePostForum(String.valueOf(user.getUserId()), forum.getPublishTime());
		reply.setForum(forumId);
		reply.setPublishUserId(user.getUserId());
		reply.setPublishUser(user.getUsername());
		reply.setReplyText(content);
		reply.setReplyTime(forum.getPublishTime());
		forumService.insertReply(reply,forumId);
		
		return "redirect:/forum/f/"+forumModuleId;
	}
	
	/**
	 * 评论
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertReply")
	public ModelAndView insertReply(HttpServletRequest request,HttpSession session)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		String forumId = request.getParameter("forumId");
		String replyText = request.getParameter("replyText");
		String floor = request.getParameter("floor");
		String userId = request.getParameter("userId");
		String forumTitle = request.getParameter("forumTitle");
		Reply reply = new Reply();
		ForumMessage message = new ForumMessage();
		
		reply.setForum(forumId);//帖子id
		reply.setReplyTime(getFormattedTime(new Date()));//时间
		reply.setReplyText(replyText);//回复内容
		reply.setReplyObject(floor);//回复几楼
		reply.setFloor(forumService.getFloorWhenInsertReply(forumId));//该回复所在楼层
		reply.setPublishUserId(user.getUserId());
		reply.setPublishUser(user.getUsername());
		forumService.insertReply(reply,forumId);
		
		message.setForumId(Integer.parseInt(forumId));
		message.setForumTitle(forumTitle);
		message.setObjectReplyId(Integer.parseInt(userId));
		message.setPersonId(user.getUserId());
		message.setPersonName(user.getUsername());
		message.setTime(reply.getReplyTime());
		
		forumService.insertMessage(message);
		modelAndView.setViewName("redirect:/forum/p/"+forumId);
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteForum")
	public ModelAndView deleteForum(HttpServletRequest request,HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		String forumId = request.getParameter("forumId");
		forumService.deleteForum(Integer.parseInt(forumId));
		modelAndView.setViewName("redirect:/forum/f/1");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteReply")
	public ModelAndView deleteReply(HttpServletRequest request,HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		String replyId = request.getParameter("replyId");
		String forumId = request.getParameter("forumId");
		forumService.deleteReply(Integer.parseInt(replyId));
		modelAndView.setViewName("redirect:/forum/p/" + forumId);
		return modelAndView;
	}
	
	@RequestMapping(value="/messageInfo")
	public void messageInfo(HttpServletResponse response,HttpSession session,HttpServletRequest request){
		StringBuffer json = new StringBuffer("{");
		User user = (User) session.getAttribute("user");
		int number = forumService.findNewMessageNumber(user.getUserId());
		json.append("'msg':'"+number+"'}");
		try {
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/myMessage")
	public ModelAndView myMessage(HttpServletRequest request,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		String messagePageIndex = request.getParameter("messagePageIndex");
		if (messagePageIndex == null) {
			messagePageIndex = "1";
		}
		Map<String, Object> map = forumService.FindAllNewMessages(user.getUserId(), messagePageIndex);
		modelAndView.setViewName("/baseView/bbsmessage");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
	
	@RequestMapping(value="/ihome_tie")
	public ModelAndView findForumsById(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String userId = request.getParameter("uid");
		String pageNum = request.getParameter("pageIndex");
		if (pageNum == null) {
			pageNum = "1";
		}
		Map<String, Object> map = forumService.FindForumByUserId(userId,pageNum);
		modelAndView.setViewName("redirect:/forum/my_tie");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
	
	@RequestMapping(value="/ihome_reply")
	public ModelAndView findReplyById(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String userId = request.getParameter("uid");
		String pageNum = request.getParameter("pageIndex");
		if (pageNum == null) {
			pageNum = "1";
		}
		Map<String, Object> map = forumService.FindReplyByUserId(userId,pageNum);
		modelAndView.setViewName("redirect:/forum/my_reply");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
}
