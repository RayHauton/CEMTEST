package com.cem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/donation")
public class DonationController {
	/*
	 * 打开donation界面
	 */
	@RequestMapping(value="/open")
	public void open(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.getRequestDispatcher("baseView/donation.jsp").forward(request, response);;
	}
}
