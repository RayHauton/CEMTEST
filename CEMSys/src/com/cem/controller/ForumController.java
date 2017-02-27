package com.cem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cem.pojo.Forum;
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
		modelAndView.setViewName("/baseView/BBSTest");
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
//		System.out.println(forumTitle);
//		System.out.println(content);
		if (content == null) {
			content = forumTitle;
		}
		String forumModuleId = String.valueOf(session.getAttribute("forumModuleId"));
		
		//对forum进行设置
		forum.setForumTitle(forumTitle);
		forum.setForumContent(content);
		forum.setPublishTime(new Date());
		forum.setUpdateTime(forum.getPublishTime());
		forum.setUserId(user.getUserId());
		forum.setUsername(user.getUsername());
		forum.setForumModule(forumModuleId);
		forumService.insertForum(forum);
		
		//同时将发帖内容发送到回复表中 （BBS格式）
		reply.setFloor((short) 1);
		reply.setForum(forumService.FindForumIdWhilePostForum(String.valueOf(user.getUserId()), getFormattedTime(forum.getPublishTime())));
		reply.setPublishUserId(user.getUserId());
		reply.setPublishUser(user.getUsername());
		reply.setReplyText(content);
		reply.setReplyTime(forum.getPublishTime());
		forumService.insertReply(reply);
		
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
		Reply reply = new Reply();
		
		reply.setForum(forumId);
		reply.setReplyTime(new Date());
		reply.setReplyText(replyText);
		reply.setReplyObject(floor);
		reply.setFloor((Short)forumService.getFloorWhenInsertReply(forumId));
		reply.setPublishUserId(user.getUserId());
		reply.setPublishUser(user.getUsername());
		forumService.insertReply(reply);
		
		modelAndView.setViewName("redirect:/forum/p/"+forumId);
		return modelAndView;
	}
}
