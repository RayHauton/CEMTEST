package com.cem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="/recruitment")
public class RecruitmentController {
	/*
	 * 打开发布招聘信息界面
	 */
	@RequestMapping(value="/open")
	public String open() throws Exception{
		return "";
	}
}
