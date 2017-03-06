package com.cem.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;
import com.cem.service.SurveySysService;

import net.sf.json.JSONArray;

/**
 * Created by RayHauton on 2017/1/31.
 */
@Controller
@RequestMapping(value = "surveySys")
public class SurveySysController {
	@Autowired
	SurveySysService surveySysService;

	@RequestMapping(value = "/open")
	public String open(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		int userID = user.getUserId();
		Selfabilityquality selfabilityquality  = surveySysService.SearchSelfabilityqualityByUserID(user.getUserId());
		Majorabilitycultivationquality majorabilitycultivationquality = surveySysService.SearchMajorabilitycultivationqualityByUserID(userID);
		String data = null;
		if(selfabilityquality!=null&&majorabilitycultivationquality!=null)
			data = selfabilityquality.toString()+","+majorabilitycultivationquality.toString();
		else if(selfabilityquality!=null&&majorabilitycultivationquality==null)
			data = selfabilityquality.toString();
		else if(selfabilityquality==null&&majorabilitycultivationquality!=null)
			data = majorabilitycultivationquality.toString();
		session.setAttribute("data",data);
		return "/baseView/personal-ability";
	}

	@RequestMapping(value = "/saveSelfabilityquality")
	public void saveSelfabilityquality(Selfabilityquality selfabilityquality, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		selfabilityquality.setUserId(user.getUserId());
		selfabilityquality.setIsDeleted("0");
		Map<String, String> map = new HashMap<String, String>();
		map.put("activityName", "添加成功");
		String s = JSONArray.fromObject(map).toString();
		response.getWriter().write(s);
		response.getWriter().flush();
		response.getWriter().close();
		surveySysService.saveSelfabilityquality(selfabilityquality);
		// return "redirect:/baseView/personal-ability.jsp";
	}
	
	@RequestMapping(value = "/saveMajorabilitycultivationquality")
	public void saveMajorabilitycultivationquality(Majorabilitycultivationquality majorabilitycultivationquality,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		majorabilitycultivationquality.setUserId(user.getUserId());
		majorabilitycultivationquality.setIsDeleted("0");
		surveySysService.saveMajorabilitycultivationquality(majorabilitycultivationquality);
		Map<String, String> map = new HashMap<String, String>();
		map.put("activityName", "添加成功");
		String s = JSONArray.fromObject(map).toString();
		response.getWriter().write(s);
		response.getWriter().flush();
		response.getWriter().close();
//		return "redirect:/baseView/personal-ability.jsp";
	}
	
	@RequestMapping(value = "/deleteByUserID")
	public String deleteByUserID(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		surveySysService.deleteSelfabilityqualityByUserID(Long.valueOf(user.getUserId()));
		surveySysService.deleteMajorabilitycultivationqualityByUserID(Long.valueOf(user.getUserId()));
		return "redirect:/baseView/personal-ability.jsp";
	}
	
	
	
}
