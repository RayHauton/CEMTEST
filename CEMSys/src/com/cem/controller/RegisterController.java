package com.cem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.pojo.User;

@Controller
public class RegisterController {
	@RequestMapping("/register")
	public void register(User user) throws Exception{
		
	}
}
