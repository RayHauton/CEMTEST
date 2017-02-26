package com.cem.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

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
	
	@RequestMapping(value="/p/{forumModuleId}")
	private ModelAndView getForumList(HttpServletRequest request,HttpServletResponse response,HttpSession session,@PathVariable(value="forumModuleId") int id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		String pageNum = request.getParameter("pageIndex");
		if (pageNum == null) {
			pageNum = "1";
		}
		int pageIndex = Integer.parseInt(pageNum);
		session.setAttribute("forumModuleId", id);
		Map<String, Object> map = forumService.FindForumwhileGointoModule(id, pageIndex);
		modelAndView.setViewName("/baseView/BBSTest");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
	
	@RequestMapping(value="/insertForum")
	private String insertForum(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		User user = (User) session.getAttribute("user");
		Forum forum = new Forum();
//		Reply reply = new Reply();
		String forumTitle = request.getParameter("forumTitle");
		System.out.println(forumTitle);
		String forumModuleId = String.valueOf(session.getAttribute("forumModuleId"));
		
		//对forum进行设置
		forum.setForumTitle(forumTitle);
		forum.setPublishTime(new Date());
		forum.setUpdateTime(forum.getPublishTime());
		forum.setUserId(user.getUserId());
		forum.setUsername(user.getUsername());
		forum.setForumModule(forumModuleId);
		forum.setViewCount(0);
		forum.setReplyCount(0);
		forum.setIsFine("0");
		forum.setIsDeleted("0");
		forumService.insertForum(forum);
		
		return "redirect:/forum/p/"+forumModuleId;
		//同时将发帖内容发送到回复表中 （BBS格式）
//		reply.setFloor((short)1);
//		reply.setForum(forumService.FindForumIdWhilePostForum(user.getUserId().toString(), forum.getPublishTime()));
//		reply.setIsDeleted("0");
//		reply.setPublishUser(user.getUserId().toString());
//		reply.setReplyText(forumTitle);
//		reply.setReplyTime(forum.getPublishTime());
//		forumService.insertReply(reply);

	}
	
	@RequestMapping(value="/insertReply")
	public String insertReply(HttpServletRequest request,HttpSession session)throws Exception{
		
		return "";
	}
}
