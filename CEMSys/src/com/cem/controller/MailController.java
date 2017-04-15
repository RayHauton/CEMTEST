package com.cem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.service.MailService;

@Controller
@RequestMapping(value="/mail")
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/audit")
	public void sentMailAfterAudit(){
		
	}
	
	@RequestMapping(value="/birthdayBlessing")
	public void sentBirthdayblessing(){
		
	}
}
