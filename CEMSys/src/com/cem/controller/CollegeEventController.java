package com.cem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 学院事件录Controller
 */
@Controller
@RequestMapping(value = "timeline")
public class CollegeEventController {
	@RequestMapping(value = "/open")
	public ModelAndView open() throws Exception{
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.setViewName("baseView/timeline");
		return modelAndView;
	}
}
