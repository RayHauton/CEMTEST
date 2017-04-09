package com.cem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/mail")
public class MailController {
	
	@RequestMapping(value="/audit")
	public void sentMailAfterAudit(){
		
	}
	
	@RequestMapping(value="/birthdayBlessing")
	public void sentBirthdayblessing(){
		
	}
}
