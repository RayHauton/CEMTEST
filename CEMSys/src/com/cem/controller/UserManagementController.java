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

import com.cem.pojo.Jobinfomodule;
import com.cem.pojo.User;
import com.cem.queryVO.UserManageVo;
import com.cem.service.JobService;
import com.cem.service.SurveySysService;
import com.cem.service.UserService;

@Controller
@RequestMapping(value = "/userManage")
public class UserManagementController {
	@Autowired
	private UserService userService;
	@Autowired
	private JobService jobService;
	@Autowired
	SurveySysService surveySysService;
	
	@RequestMapping(value = "/open")
	public ModelAndView openJsp(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		String mobile = user.getMobile();
		if (userService.findUserByMobile(mobile, true) != null)
			modelAndView.setViewName("admin/userManage");
		else {
			modelAndView.setViewName("login/login");
		}

		modelAndView.addObject("approvedsum", 0);
		modelAndView.addObject("disapprovedsum", 0);
		return modelAndView;
	}

	@RequestMapping(value = "/findUsers")
	public ModelAndView findUsers(UserManageVo userManageVo) throws Exception {
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
		System.out.println("修改成功");
		System.out.println("//////");
		return modelAndView;
	}

	@RequestMapping(value = "/findUser")
	public void findUser(UserManageVo userManageVo, HttpServletResponse response, HttpSession session)
			throws Exception {
		// ModelAndView modelAndView =new ModelAndView();
		System.out.println(userManageVo.getStudNumber());
		User user = userService.findUserByStudNum(userManageVo.getStudNumber(), false);
		if (user == null)
			System.out.println("失敗");
		else {
			// modelAndView.addObject("userDetail", user);
			System.out.println("");
			String result = user.getUsername() + "/" + user.getTruename() + "/" + user.getSex() + "/"
					+ user.getStudNumber() + "/" + user.getBirth() + "/" + user.getMobile() + "/" + user.getEmail()
					+ "/" + user.getAddress() + "/" + user.getEntranceDate() + "/" + user.getGraduateDate();
			response.setCharacterEncoding("UTF-8");  
		    response.setContentType("text/html; charset=UTF-8"); 
			response.getWriter().write(result);
		}

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
		if (userService.deleteUser(user)){
			jobService.deleteJobInf(jobService.findJobInfByUserId(user.getUserId()));
			jobService.deleteJobCon(jobService.finJobConByUserId(user.getUserId()));
			surveySysService.deleteSelfabilityqualityByUserID(user.getUserId());
			surveySysService.deleteMajorabilitycultivationqualityByUserID(user.getUserId());
			response.getWriter().write("success");}
		else {
			response.getWriter().write("noExist");
		}
		
	}

	@RequestMapping(value = "/check")
	public void checkUserStates(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] studNumberArr = request.getParameterValues("studNumber");
		String[] auditArr = request.getParameterValues("audit_states");
		userService.checkUserStates(studNumberArr, auditArr);
		response.getWriter().write("success");
	}

}
