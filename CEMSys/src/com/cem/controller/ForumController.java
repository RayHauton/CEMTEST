package com.cem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
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
@RequestMapping(value = "/forum")
public class ForumController {
	@Autowired
	private ForumService forumService;

	// 选择一个模块进入 得到帖子列表
	@RequestMapping(value = "/f/{forumModuleId}")
	private ModelAndView getForumList(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "forumModuleId") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String pageNum = checkNULLAndSet(getParameter(request, "forumIndex"), "1");
		session.setAttribute("forumModuleId", id);
		Map<String, Object> map = forumService.FindForumwhileGointoModule(id, Integer.parseInt(pageNum));
		modelAndView.setViewName("/baseView/bbsforum");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}

	// 进入帖子 得到回复列表
	@RequestMapping(value = "/p/{forumId}")
	private ModelAndView getReplyList(HttpServletRequest request, @PathVariable(value = "forumId") int forumId)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String pageNum = checkNULLAndSet(getParameter(request, "pageNum"), "1");
		Map<String, Object> map = forumService.FindReplywhileGointoForum(forumId, Integer.parseInt(pageNum));
		modelAndView.addAllObjects(map);
		modelAndView.setViewName("/baseView/bbs_reply");
		return modelAndView;
	}

	// 发帖
	@RequestMapping(value = "/insertForum")
	private String insertForum(HttpServletRequest request, HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		String[] parameters = getParameters(request, new String[] { "forumTitle", "forumContent" });
		String forumTitle = parameters[0];
		String content = checkNULLAndSet(parameters[1], forumTitle);
		String forumModuleId = String.valueOf(session.getAttribute("forumModuleId"));

		// 对forum进行设置
		Forum forum = new Forum(forumTitle, content, forumModuleId, user.getUserId(), user.getUsername(),
				user.getTruename(), getFormattedTime(new Date()), getFormattedTime(new Date()));
		forumService.insertForum(forum);

		// 同时将发帖内容发送到回复表中 （BBS格式）
		Reply reply2 = new Reply(content, user.getUserId(), user.getUsername(), String.valueOf(forum.getForumId()),
				(short) 1, forum.getPublishTime());
		forumService.insertReply(reply2, String.valueOf(forum.getForumId()));

		return "redirect:/forum/f/" + forumModuleId;
	}

	// 评论
	@RequestMapping(value = "/insertReply")
	public ModelAndView insertReply(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");

		String[] parameters = getParameters(request,
				new String[] { "forumId", "replyText", "floor", "userId", "forumTitle", "objectReplyContent" });
		String forumId = parameters[0];
		String replyText = parameters[1];
		String floor = parameters[2];
		String userId = parameters[3];
		String forumTitle = parameters[4];
		String objectReplyContent = parameters[5];
		Reply reply2 = new Reply(replyText, user.getUserId(), user.getUsername(), forumId,
				forumService.getFloorWhenInsertReply(forumId), getFormattedTime(new Date()), floor);
		if (objectReplyContent != null) {
			if (objectReplyContent.length() > 200) {
				reply2.setParentReplyId(objectReplyContent.substring(0, 200));
			} else {
				reply2.setParentReplyId(objectReplyContent);
			}
		}
		forumService.insertReply(reply2, forumId);
		ForumMessage message = new ForumMessage(Integer.parseInt(forumId), forumTitle, user.getUserId(),
				user.getUsername(), reply2.getReplyTime(), Integer.parseInt(userId));
		forumService.insertMessage(message);
		modelAndView.setViewName("redirect:/forum/p/" + forumId);
		return modelAndView;
	}

	// 删除帖子
	@RequestMapping(value = "/deleteForum")
	public ModelAndView deleteForum(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String forumId = getParameter(request, "forumId");
		forumService.deleteForum(Integer.parseInt(forumId));
		modelAndView.setViewName("redirect:/forum/f/1");

		return modelAndView;
	}

	// 删除回复
	@RequestMapping(value = "/deleteReply")
	public ModelAndView deleteReply(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String[] parameters = getParameters(request, new String[] { "replyId", "forumId" });
		String replyId = parameters[0];
		String forumId = parameters[1];
		forumService.deleteReply(Integer.parseInt(replyId));
		modelAndView.setViewName("redirect:/forum/p/" + forumId);
		return modelAndView;
	}

	// 消息通知数目
	@RequestMapping(value = "/messageInfo")
	public void messageInfo(HttpServletResponse response, HttpSession session, HttpServletRequest request) {
		StringBuffer json = new StringBuffer("{");
		User user = (User) session.getAttribute("user");
		int number = forumService.findNewMessageNumber(user.getUserId());
		json.append("'msg':'" + number + "'}");
		try {
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 我的消息
	@RequestMapping(value = "/myMessage")
	public ModelAndView myMessage(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		String messagePageIndex = checkNULLAndSet(request.getParameter("messagePageIndex"), "1");
		Map<String, Object> map = forumService.FindAllNewMessages(user.getUserId(), messagePageIndex);
		modelAndView.setViewName("/baseView/bbs_message");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}

	// 我的帖子
	@RequestMapping(value = "/ihome_tie")
	public ModelAndView findForumsById(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String[] parameters = getParameters(request, new String[] { "uid", "pageIndex" });
		String userId = parameters[0];
		String pageNum = checkNULLAndSet(parameters[1], "1");
		Map<String, Object> map = forumService.FindForumByUserId(userId, pageNum);
		modelAndView.setViewName("/forum/ihome_tie");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}

	// 我的回复
	@RequestMapping(value = "/ihome_reply")
	public ModelAndView findReplyById(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String[] parameters = getParameters(request, new String[] { "uid", "pageIndex" });
		String userId = parameters[0];
		String pageNum = checkNULLAndSet(parameters[1], "1");
		Map<String, Object> map = forumService.FindReplyByUserId(userId, pageNum);
		modelAndView.setViewName("/forum/ihome_reply");
		modelAndView.addAllObjects(map);
		return modelAndView;
	}

	// 得到参数
	private String getParameter(HttpServletRequest request, String parameterName) {
		return request.getParameter(parameterName);
	}

	private String[] getParameters(HttpServletRequest request, String[] parameters) {
		String[] result = new String[parameters.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = getParameter(request, parameters[i]);
		}
		return result;
	}

	// 检查是否为空 空则置为value
	private String checkNULLAndSet(String toCheck, String value) {
		return (toCheck == null) ? value : toCheck;
	}

	// 规范时间
	private String getFormattedTime(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}
}
