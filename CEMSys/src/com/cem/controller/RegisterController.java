package com.cem.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.customPojo.UserCustom;
import com.cem.pojo.User;
import com.cem.service.SchoolExperienceService;
import com.cem.service.UserService;
import com.cem.util.JsonUtil;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private SchoolExperienceService schoolExperienceService;
	/*
	 * @RequestMapping("/test") public void test() { User user = null;
	 * System.out.println(user.getAddress()); // throw new
	 * NullPointerException(); }
	 */

	@RequestMapping("/register")
	public void register(UserCustom userCustom, HttpServletResponse response) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userCustom, user);
		user.setRole("0");
		user.setSchoolExperienceId(
				schoolExperienceService.findSchoolExperienceByMajorIdAndDegreeId(userCustom).getSchooleExperienceId());
		User queryUser = userService.findIfUserExist(user.getUsername(), user.getMobile(), user.getStudNumber(), user.getEmail());
		if(queryUser!=null){
			user.setUserId(queryUser.getUserId());
			//更细用户而不是添加用户
			user.setCheckOut("0");
			user.setIsDeleted("0");
			userService.updateUser(user);
		}else{
			userService.insertUser(user);
		}
		response.getWriter().write("succ");
	}

	/*
	 * 根据用户选择的学位水平进行专业的筛选
	 */
	@RequestMapping(value = "/chooseMajor")
	public void chooseMajor(String degreeId, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(JsonUtil.generatorJsonForMajors(schoolExperienceService.findMajorsByDegreeId(degreeId)));
		writer.flush();
		writer.close();
	}

	/*
	 * 注册时候的检验 用户名、手机号码、邮箱、学号不能重复；
	 */
	@RequestMapping("/registerCheck")
	public void registerCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String check = request.getParameter("check");
		String checkValue = request.getParameter("checkValue");
		if (check != null) {
			User user = null;
			PrintWriter writer = response.getWriter();
			if (check.equals("username")) {// 验证用户名是否为一
				user = userService.findUserByUsername(checkValue, true);// 参数为true，说明查找的是已经审核通过的用户
				if (user != null) {// 说明系统中已经存在注册且已经审核通过的用户，因而不能用该用户名进行注册
					writer.write("usernameExist");
				}
			} else if (check.equals("mobile")) {// 检查注册的手机号是否为一
				user = userService.findUserByMobile(checkValue, true);
				if (user != null) {// 道理同用户名
					writer.write("mobileExist");
				}
			} else if (check.equals("email")) {// 邮箱
				user = userService.finduserByEmail(checkValue, true);
				if (user != null) {
					writer.write("emailExist");
				}
			} else if (check.equals("studNum")) {
				user = userService.findUserByStudNum(checkValue, true);
				if (user != null) {
					writer.write("studNumberExist");
				}
			} else {
				// 正常注册；
			}
		}
	}
}
