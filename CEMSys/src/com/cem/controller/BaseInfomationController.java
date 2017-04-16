package com.cem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.pojo.Companynature;
import com.cem.pojo.Income;
import com.cem.pojo.Jobcontitionmodule;
import com.cem.pojo.Jobinfomodule;
import com.cem.pojo.Transferjobcount;
import com.cem.pojo.User;
import com.cem.service.JobService;
import com.cem.service.UserService;

/**
 * Created by RayHauton on 2017/1/29.
 */
@Controller
@RequestMapping(value = "/infoSys")
public class BaseInfomationController {
	@Autowired
	private UserService userservice = null;

	@Autowired
	private JobService jobService = null;

	@RequestMapping(value = "/open")
	public String open(HttpSession session) throws Exception {
		User user;
		System.out.println("从action跳转");
		String username = ((User) session.getAttribute("user")).getUsername();
		String mobile = ((User) session.getAttribute("user")).getMobile();
		String email = ((User) session.getAttribute("user")).getEmail();
//		System.out.println(username);
//		System.out.println(mobile);
//		System.out.println(email);
		if (username != null && !("".equals(username))) {
			user = userservice.findUserByUsername(username, true);
//			System.out.println("username");
		} else if (mobile != null && !("".equals(mobile))) {
			user = userservice.findUserByMobile(mobile, true);
//			System.out.println("mobil");
		} else if (email != null && !("".equals(email))) {
			user = userservice.finduserByEmail(email, true);
//			System.out.println("email");
		} else {
//			System.out.println("全部为空");
			return "redirect:/login/login.jsp";
		}

		if (user == null) {
//			System.out.println("不存在用户，准备跳转");
			return "redirect:/login/login.jsp";
		} else {
//			System.out.println("存在用户，准备跳转");
			return "redirect:/baseView/base-information.jsp";

		}

	}

	@RequestMapping(value = "/updatebaseInf")
	public void updateBaseInf(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		// Map<String, Object> map = new HashMap<String,Object>();
		System.out.println("调用updateBaseInf");
		User user = userservice.findUserByUsername(((User) session.getAttribute("user")).getUsername(), true);
		if (user != null) {
			user.setTruename(request.getParameter("truename"));
			user.setSex(request.getParameter("sex"));
			user.setBirth(request.getParameter("birth"));
			System.out.println(request.getParameter("province1"));
			System.out.println(request.getParameter("city1"));
			System.out.println(request.getParameter("district1"));
			System.out.println(request.getParameter("country") + "-" + request.getParameter("province1") + "-"
					+ request.getParameter("city1") + "-" + request.getParameter("district1"));
			if (request.getParameter("country").equals("inChina")) {
				String address = request.getParameter("country") + "-" + request.getParameter("province1") + "-"
						+ request.getParameter("city1") + "-" + request.getParameter("district1");
				System.out.println(address);
				user.setAddress(address);
				System.out.println(user.getAddress());
			} else {
				user.setAddress(request.getParameter("country") + "-" + request.getParameter("address"));
			}

			// System.out.println(user.getUsername());
			// System.out.println(user.getTruename());
			// System.out.println(user.getSex());
			// System.out.println(user.getBirth());
			// System.out.println(user.getAddress());
			//// map.put("result", "success");
			//// String s = JSONArray.fromObject(map).toString();
			userservice.updateUser(user);
			response.getWriter().write("succ");
		} else {
			response.getWriter().write("noExist");
		}
		// System.out.println("结束了");

	}

	@RequestMapping(value = "/jopInf")
	public void InsertJobInf(Jobinfomodule jobinfomodule, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) throws Exception {
		System.out.println("调用JOB增加Con方法");
		Companynature companynature = jobService.findComNature(jobinfomodule.getCompanyNature());
		System.out.println(((User) session.getAttribute("user")).getMobile());
		User user = userservice.findUserByMobile(((User) session.getAttribute("user")).getMobile(), true);
		if (user != null && companynature != null) {
			Jobinfomodule jobinfomodule2 = jobService
					.findJobInfByUserId(((User) session.getAttribute("user")).getUserId());
			jobinfomodule.setUserId(((User) session.getAttribute("user")).getUserId());
			jobinfomodule.setIsDeleted("0");
			System.out.println("准备比较");
			if (jobinfomodule2 == null) {
				System.out.println("目标值不存在");
				jobService.insertJobInf(jobinfomodule);
				response.getWriter().write("succ");
			} else {
				System.out.println("目标值已存在");
				jobService.deleteJobInf(jobinfomodule2.getUserId());
				jobService.insertJobInf(jobinfomodule);
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("覆盖成功");

			}
		} else {
			response.getWriter().write("noExist");
		}
	}

	@RequestMapping(value = "/jobCon")
	public void InsertJobCon(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		System.out.println("调用工作信息模块控制层");
		Transferjobcount transferjobcount = jobService.findTranCountByCountId(request.getParameter("transferJobCount"));
		Income income = jobService.findIncomeByIncomeId(request.getParameter("income"));
		User user = userservice.findUserByUsername(((User) session.getAttribute("user")).getUsername(), true);
		if (transferjobcount != null && income != null && user != null) {
			String[] reson = request.getParameterValues("reasonOfNotStatis");
			String reString = "";
			for (int i = 0; i < reson.length; i++) {
				reString += reson[i];
				reString += ":";
			}
			Jobcontitionmodule jobcontitionmodule = new Jobcontitionmodule();
			jobcontitionmodule.setReasonOfNotStatis(reString);
			jobcontitionmodule.setCompanyExamine(Short.parseShort((request.getParameter("companyExamine"))));
			jobcontitionmodule.setFirstPromote(Integer.parseInt(request.getParameter("firstPromote")));
			jobcontitionmodule.setHonorLevel(Short.parseShort(request.getParameter("honorLevel")));
			jobcontitionmodule.setHonorName(request.getParameter("honorName"));
			jobcontitionmodule.setIncome(request.getParameter("income"));
			jobcontitionmodule.setIsDeleted("0");
			jobcontitionmodule.setSatisLevelOfBusinessSelf(request.getParameter("satisLevelOfBusinessSelf"));
			jobcontitionmodule.setSatisLevelOfCurrJob(request.getParameter("satisLevelOfCurrJob"));
			jobcontitionmodule.setTransferJobCount(Integer.parseInt(request.getParameter("transferJobCount")));
			jobcontitionmodule.setUserId(((User) session.getAttribute("user")).getUserId());
			jobcontitionmodule.setYearsToBusinessSelf(Integer.parseInt(request.getParameter("yearsToBusinessSelf")));
			jobService.insertJobCon(jobcontitionmodule);
			response.getWriter().write("succ");
		} else {
			response.getWriter().write("noExist");
		}
	}
}
