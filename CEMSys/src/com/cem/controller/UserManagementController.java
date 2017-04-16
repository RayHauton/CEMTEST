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

import com.cem.pojo.Jobcontitionmodule;
import com.cem.pojo.Jobinfomodule;
import com.cem.pojo.Major;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Schoolexperience;
import com.cem.pojo.User;
import com.cem.queryVO.UserManageVo;
import com.cem.service.DegreeService;
import com.cem.service.JobService;
import com.cem.service.MajorService;
import com.cem.service.SchoolExperienceService;
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

	@Autowired
	SchoolExperienceService schoolExperienceService;
	@Autowired
	DegreeService degreeService;

	@Autowired

	MajorService majorService;

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
	public void alterPassword(HttpSession session, HttpServletResponse response, @RequestParam int userId,
			@RequestParam String oriPass, @RequestParam String newPass) throws Exception {
		String passInDB = userService.findPassword(userId);
		if (passInDB.equals(oriPass)) {// 将用户输入的密码与数据库中的密码进行比较
			if (passInDB.equals(newPass)) {// 新旧密码不能相同
				response.getWriter().write("passSame");
			} else {
				if (userService.alterPassword(userId, newPass)) {
					response.getWriter().write("succ");
					session.removeAttribute("user");
				} else {
					response.getWriter().write("error");
				}
			}
		} else {
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
		System.out.println("准备跳转");
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		String mobile = user.getMobile();
		String username = user.getUsername();
		String email = user.getEmail();
		User manage = null;
		if (username != null && !("".equals(username))) {
			manage = userService.findUserByUsername(username, true);
			System.out.println(username);
		} else if (mobile != null && !("".equals(mobile))) {
			manage = userService.findUserByMobile(mobile, true);
			System.out.println(mobile);
		} else if (email != null && !("".equals(email))) {
			manage = userService.finduserByEmail(email, true);
			System.out.println(email);
		} else {
			System.out.println("全空");
			modelAndView.setViewName("login/login");
		}
		if (manage != null && "1".equals(manage.getRole())) {
			modelAndView.setViewName("admin/userManage");
			modelAndView.addObject("approvedsum", 0);
			modelAndView.addObject("disapprovedsum", 0);
		} else {
			if (manage == null)
				System.out.println("用户不存在");
			if ("1".equals(manage.getRole()))
				System.out.println("非管理员");
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
		System.out.println(userManageVo.getUsername());
		User user = userService.findUserByUsername(userManageVo.getUsername(), true);
		if (user == null)
			System.out.println("失敗");
		else {
			System.out.println(user.getSchoolExperienceId());
			Schoolexperience schoolexperience = schoolExperienceService
					.findBySchoolExpericenceId(user.getSchoolExperienceId());
			System.out.println("找到专业");
			String degreeId;
			String majorId;
			if (schoolexperience == null) {
				degreeId = "";
				majorId = "";
			} else {
				degreeId = schoolexperience.getDegreeId();
				majorId = schoolexperience.getMajorId();
			}
			String result = user.getUsername() + "/" + user.getTruename() + "/" + user.getSex() + "/"
					+ user.getStudNumber() + "/" + user.getBirth() + "/" + user.getMobile() + "/" + user.getEmail()
					+ "/" + user.getAddress() + "/" + user.getEntranceDate() + "/" + user.getGraduateDate() + "/"
					+ degreeId + "/" + majorId;
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
	public void userDelete(String username, HttpServletResponse response) throws Exception {
		System.out.println(username);
		System.out.println("准备删除");
		User user = userService.findUserByUsername(username, true);
		if (userService.deleteUser(user)) {
			// Jobinfomodule jobinfomodule =
			// jobService.findJobInfByUserId(user.getUserId());
			if (jobService.deleteJobInf(user.getUserId()))
				System.out.println(1);
			// Jobcontitionmodule jobcontitionmodule =
			// jobService.finJobConByUserId(user.getUserId());
			System.out.println("已找到");
			if (jobService.deleteJobCon(user.getUserId()))
				System.out.println(2);
			;
			surveySysService.deleteSelfabilityqualityByUserID(user.getUserId());
			surveySysService.deleteMajorabilitycultivationqualityByUserID(user.getUserId());
			System.out.println("相关全部删除");
			response.getWriter().write("success");
		} else {
			response.getWriter().write("noExist");
		}

	}

	@RequestMapping(value = "update_adm")
	public void update_admin(UserManageVo userManageVo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			User user = userService.findUserByUsername(userManageVo.getUsername(), true);
			System.out.println(userManageVo.getUsername());
			System.out.println(userManageVo.getTruename());
			System.out.println(userManageVo.getSex());
			System.out.println(userManageVo.getStudNumber());
			System.out.println(userManageVo.getBirth());
			System.out.println(userManageVo.getMobile());
			System.out.println(userManageVo.getEmail());
			System.out.println(userManageVo.getAddress());
			String schoolExId = schoolExperienceService
					.findSchoolExperienceByMajorIdAndDegreeId(userManageVo.getDegreeId(), userManageVo.getMajorId())
					.getSchooleExperienceId();
			if (user == null)
				response.getWriter().write("fail");
			else {
				user.setUsername(userManageVo.getUsername());
				user.setTruename(userManageVo.getTruename());
				user.setSex(userManageVo.getSex());
				user.setStudNumber(userManageVo.getStudNumber());
				user.setBirth(userManageVo.getBirth());
				user.setMobile(userManageVo.getMobile());
				user.setEmail(userManageVo.getEmail());
				user.setAddress(userManageVo.getAddress());
				user.setEntranceDate(userManageVo.getEntranceDate());
				user.setGraduateDate(userManageVo.getGraduateDate());
				user.setSchoolExperienceId(schoolExId);
				userService.updateUser(user);
				response.getWriter().write("success");
			}
		} catch (Exception e) {
			response.getWriter().write("fail");
		}
	}

	@RequestMapping(value = "update_ability")
	public void update_ability(UserManageVo userManageVo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		try {
			User user = userService.findUserByStudNum(((User) session.getAttribute("user")).getStudNumber(), true);
			if (user == null) {
				System.out.println("用户不存在");
				response.getWriter().write("fail");
			} else {
				user.setUsername(userManageVo.getUsername());
				user.setTruename(userManageVo.getTruename());
				user.setSex(userManageVo.getSex());
				user.setBirth(userManageVo.getBirth());
				user.setMobile(userManageVo.getMobile());
				user.setEmail(userManageVo.getEmail());
				user.setAddress(userManageVo.getAddress());
				user.setEntranceDate(userManageVo.getEntranceDate());
				user.setGraduateDate(userManageVo.getGraduateDate());
				userService.updateUser(user);
				session.setAttribute("user", user);
				response.getWriter().write("success");
			}
		} catch (Exception e) {
			response.getWriter().write("fail");
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
