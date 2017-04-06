package com.cem.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/openClassmatesView")
	public void openClassmatesView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/baseView/classmates.jsp").forward(request, response);
		;
	}

	/**
	 * 修改用户密码操作
	 * 
	 * @param reponse
	 * @param userId
	 *            用户id
	 * @param password
	 *            密码
	 * @throws Exception
	 */
	@RequestMapping(value = "/alterPassword")
	public void alterPassword(HttpSession session,HttpServletResponse response, @RequestParam int userId, @RequestParam String oriPass,
			@RequestParam String newPass) throws Exception {
		String passInDB = userService.findPassword(userId);
		if(passInDB.equals(oriPass)){//将用户输入的密码与数据库中的密码进行比较
			if(passInDB.equals(newPass)){//新旧密码不能相同
				response.getWriter().write("passSame");
			}else{
				if(userService.alterPassword(userId, newPass)){
					response.getWriter().write("succ");
					session.removeAttribute("user");
				}else{
					response.getWriter().write("error");
				}
			}
		}else{
			response.getWriter().write("passError");
		}
	}

	@RequestMapping(value = "/findClassmatesByClassNo")
	public ModelAndView findClassmatesByIdClassNo(@RequestParam String truename, @RequestParam String classNo)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("classmatesList", userService.findClassMateByClasNo(truename, classNo));
		modelAndView.addObject("truename", truename);
		modelAndView.addObject("classNo", classNo);
		modelAndView.setViewName("baseView/classmates");
		return modelAndView;
	}

	@RequestMapping(value = "/open")
	public ModelAndView openJsp(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		String mobile = user.getMobile();
		if (userService.findUserByMobile(mobile, true) != null) {
			modelAndView.setViewName("admin/userManage");
			modelAndView.addObject("approvedsum", 0);
			modelAndView.addObject("disapprovedsum", 0);
		} else {
			modelAndView.setViewName("login/login");
		}

		return modelAndView;
	}

	/* 大量查询用户信息 */
	@RequestMapping(value = "/findUsers_adm")
	public ModelAndView findUsers(UserManageVo userManageVo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		// userManageVo.setPageSize("100");
		Map<String, Object> result = userService.findUsersFromUserManage(userManageVo);
		if (result.get("approved") == null) {
			modelAndView.addObject("approvedsum", 0);
		} else {
			modelAndView.addObject("approvedUserList", result.get("approved"));
			modelAndView.addObject("approvedsum", ((UserManageVo) result.get("userManageVo")).getRecordCount());
		}
		if (result.get("disapproved") == null) {
			modelAndView.addObject("disapprovedsum", 0);
		} else {
			modelAndView.addObject("disapprovedUserList", result.get("disapproved"));
			modelAndView.addObject("disapprovedsum", ((UserManageVo) result.get("userManageVo")).getRecordCount());
		}
		int recordCount = Integer.parseInt(((UserManageVo) result.get("userManageVo")).getRecordCount());
		int pageSize = Integer.parseInt(((UserManageVo) result.get("userManageVo")).getPageSize());
		int pageCount = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;
		((UserManageVo) result.get("userManageVo")).setPageCount(pageCount);
		((UserManageVo) result.get("userManageVo")).setAccessMode("findUsers");
		System.out.println(((UserManageVo) result.get("userManageVo")).getPageCount());
		System.out.println(((UserManageVo) result.get("userManageVo")).getPageIndex());
		modelAndView.addObject("userManageVo", result.get("userManageVo"));
		modelAndView.setViewName("admin/userManage");
		return modelAndView;
	}

	/* 单个用户详情查询 */
	@RequestMapping(value = "/findUser_adm")
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

	@RequestMapping(value = "/findUserWithout_adm")
	public ModelAndView findUserWithout(UserManageVo userManageVo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("准备进入dao层");
		Map<String, Object> result = userService.findUsersFromUserManageWithOut(userManageVo);
		if (result.get("approved") == null) {
			modelAndView.addObject("approvedsum", 0);
		} else {
			modelAndView.addObject("approvedUserList", result.get("approved"));
			modelAndView.addObject("approvedsum", ((UserManageVo) result.get("userManageVo")).getRecordCount());
		}
		if (result.get("disapproved") == null) {
			modelAndView.addObject("disapprovedsum", 0);
		} else {
			modelAndView.addObject("disapprovedUserList", result.get("disapproved"));
			modelAndView.addObject("disapprovedsum", ((UserManageVo) result.get("userManageVo")).getRecordCount());
		}
		int recordCount = Integer.parseInt(((UserManageVo) result.get("userManageVo")).getRecordCount());
		int pageSize = Integer.parseInt(((UserManageVo) result.get("userManageVo")).getPageSize());
		int pageCount = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;
		((UserManageVo) result.get("userManageVo")).setPageCount(pageCount);
		((UserManageVo) result.get("userManageVo")).setAccessMode("findUserWithout");
		modelAndView.addObject("userManageVo", result.get("userManageVo"));
		modelAndView.setViewName("admin/userManage");
		return modelAndView;
	}

	@RequestMapping(value = "/userDelete_adm")
	public void userDelete(String studNumber, HttpServletResponse response) throws Exception {
		System.out.println(studNumber);
		System.out.println("准备删除");
		User user = new User();
		user.setStudNumber(studNumber);
		if (userService.deleteUser(user)) {
			jobService.deleteJobInf(jobService.findJobInfByUserId(user.getUserId()));
			jobService.deleteJobCon(jobService.finJobConByUserId(user.getUserId()));
			surveySysService.deleteSelfabilityqualityByUserID(user.getUserId());
			surveySysService.deleteMajorabilitycultivationqualityByUserID(user.getUserId());
			response.getWriter().write("success");
		} else {
			response.getWriter().write("noExist");
		}

	}

	@RequestMapping(value = "/check_adm")
	public void checkUserStates(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] studNumberArr = request.getParameterValues("studNumber");
		String[] auditArr = request.getParameterValues("audit_states");
		userService.checkUserStates(studNumberArr, auditArr);
		response.getWriter().write("success");
	}

	@RequestMapping(value = "/downloadUsers_adm")
	public void downloadUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> uList = userService.findUserWithOut();
		userService.downloadUsers(uList, request, response);
	}

}
