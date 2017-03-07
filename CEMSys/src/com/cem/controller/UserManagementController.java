package com.cem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cem.pojo.User;
import com.cem.service.UserService;

@Controller
@RequestMapping(value = "/userManage")
public class UserManagementController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/findUser")
	public ModelAndView findUser(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String studNumber = req.getParameter("studNumber");
		String trueName = req.getParameter("trueName");
		String entranceDate = req.getParameter("entranceDate");
		int pagesize = Integer.parseInt(req.getParameter("pageSize"));
		Map<String, Object> queryResult = new HashMap<>();
		List<User> ulist = new ArrayList<>();
		boolean audit;
		if (req.getParameter("audit") == "0") {
			audit = true;
		} else {
			audit = false;
		}
		if ((studNumber != null) && !("".equals(studNumber))) {
			User user = userService.findUserByStudNum(studNumber, audit);
			ulist.add(user);
			modelAndView.addObject("userList", ulist);
			modelAndView.addObject("sum", "1");
		} else {
			if (trueName != null && !("".equals(trueName)) && entranceDate == null && "".equals(entranceDate)) {
				ulist = userService.findUsersByTrueName(trueName, audit, pagesize);
				modelAndView.addObject("userList", ulist);
				modelAndView.addObject("sum", ulist.size());
			} else if (trueName == null && "".equals(trueName) && entranceDate != null || !("".equals(entranceDate))) {
				ulist = userService.findUsersByEntranceDate(entranceDate, audit, pagesize);
				modelAndView.addObject("userList", ulist);
				modelAndView.addObject("sum", ulist.size());
			}else if (trueName != null && !("".equals(trueName)) && entranceDate != null || !("".equals(entranceDate))) {
				ulist = userService.finUserByEnAndTrueName(entranceDate, trueName, audit, pagesize);
				modelAndView.addObject("userList", ulist);
				modelAndView.addObject("sum", ulist.size());
			}
		}
		modelAndView.setViewName("admin/userManage");
		return modelAndView;
	}

}
