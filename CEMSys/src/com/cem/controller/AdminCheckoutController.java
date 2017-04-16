package com.cem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.pojo.User;
import com.cem.service.AdminCheckoutService;
import com.cem.util.BeanUtil;
import com.cem.util.MailUtil;


/**
 * 
 * @author nc硪fl
 *
 */
@Controller
@RequestMapping(value = "/checkout")
public class AdminCheckoutController {

	@Autowired
	private AdminCheckoutService adminCheckoutService;
	
	@RequestMapping(value = "/open_adm")
	public String open(HttpSession session) throws Exception{
		List<List<String>> result = new ArrayList<List<String>>();
		List<User> userList = adminCheckoutService.getUncheckoutUser();
		for (User user : userList) {
			System.out.println(user);
			List<String> temp = adminCheckoutService.checkouting(user);
			result.add(temp);
		}
		session.setAttribute("result", result);
		System.out.println(result);
		return  "redirect:/admin/checkout.jsp";
	}
	
	
	@RequestMapping(value = "/audit_adm")
	public String audit(HttpServletRequest request) throws Exception{
		String username = request.getParameter("username");
		String flag = request.getParameter("flag");
		adminCheckoutService.Audit(flag, username);
		String email = adminCheckoutService.getEmailByUsername(username);
		((MailUtil) BeanUtil.getBean(MailUtil.class)).sendMail(new String[]{email}, 
				"南京航空航天大学经济与管理学院校友系统", 
				"尊敬的用户，您的用户信息通过了审核。南京航空航天大学经济与管理学院校友系统欢迎您", 
				null);
		return  "redirect:/checkout/open_adm.action";
	}
	
	@RequestMapping(value = "/auditSelected_adm")
	public String auditSelected(HttpServletRequest request) throws Exception{
		String[] checkout = request.getParameterValues("check-box");
		String flag = request.getParameter("tempInput");
		System.err.println(flag);
		List<User> userList = adminCheckoutService.getUncheckoutUser();
		for (String string : checkout) {
			String username = userList.get(Integer.valueOf(string)).getUsername();
			adminCheckoutService.Audit(flag, username);
			String email = adminCheckoutService.getEmailByUsername(username);
			((MailUtil) BeanUtil.getBean(MailUtil.class)).sendMail(new String[]{email}, 
					"南京航空航天大学经济与管理学院校友系统", 
					"尊敬的用户，您的用户信息通过了审核。南京航空航天大学经济与管理学院校友系统欢迎您", 
					null);
		}
		return  "redirect:/checkout/open_adm.action";
	}
	
	
}
