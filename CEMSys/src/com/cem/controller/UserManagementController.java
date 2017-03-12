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
import com.cem.queryVO.UserManageVo;
import com.cem.service.UserService;

@Controller
@RequestMapping(value = "/userManage")
public class UserManagementController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/findUser")
	public ModelAndView findUser(UserManageVo userManageVo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		// userManageVo.setPageSize("100");
		Map<String, List<Object>> result = userService.findUsersFromUserManage(userManageVo);
		if (result.get("approved") == null) {
			modelAndView.addObject("approvedsum", 0);
		} else {
			modelAndView.addObject("approvedUserList", result.get("approved"));
			modelAndView.addObject("approvedsum", result.get("approved").size());
		}
		if (result.get("disapproved") == null) {
			modelAndView.addObject("disapprovedsum", 0);
		} else {
			modelAndView.addObject("disapprovedUserList", result.get("disapproved"));
			modelAndView.addObject("disapprovedsum", result.get("disapproved").size());
		}
		modelAndView.setViewName("admin/userManage");
		modelAndView.setViewName("admin/userManage");
		System.out.println("修改成功");
		System.out.println("//////");
		return modelAndView;
	}

	@RequestMapping(value = "/findUserWithout")
	public ModelAndView findUserWithout(UserManageVo userManageVo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("准备进入dao层");
		Map<String, List<Object>> result = userService.findUsersFromUserManageWithOut(userManageVo.getAudit());
		if (result.get("approved") == null) {
			modelAndView.addObject("approvedsum", 0);
		} else {
			modelAndView.addObject("approvedUserList", result.get("approved"));
			modelAndView.addObject("approvedsum", result.get("approved").size());
		}
		if (result.get("disapproved") == null) {
			modelAndView.addObject("disapprovedsum", 0);
		} else {
			modelAndView.addObject("disapprovedUserList", result.get("disapproved"));
			modelAndView.addObject("disapprovedsum", result.get("disapproved").size());
		}
		modelAndView.setViewName("admin/userManage");
		return modelAndView;
	}

	@RequestMapping(value = "/userDelete")
	public void userDelete(String studNumber, HttpServletResponse response) throws Exception {
		System.out.println(studNumber);
		System.out.println("准备删除");
		User user = new User();
		user.setStudNumber(studNumber);
		if (userService.deleteUser(user))
			response.getWriter().write("success");
		else {
			response.getWriter().write("noExist");
		}
	}
	
	@RequestMapping(value="/check")
	public void checkUserStates(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String[] studNumberArr = request.getParameterValues("studNumber");
		String[] auditArr  =request.getParameterValues("audit_states");
		userService.checkUserStates(studNumberArr, auditArr);
		response.getWriter().write("success");
	}

}
