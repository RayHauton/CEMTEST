package com.cem.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.sun.swing.internal.plaf.synth.resources.synth_ja;

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
		String userID = user.getUserId().toString();
		Selfabilityquality selfabilityquality  = surveySysService.SearchSelfabilityqualityByUserID(userID);
		Majorabilitycultivationquality majorabilitycultivationquality = surveySysService.SearchMajorabilitycultivationqualityByUserID(userID);
		String data = null;
		if(selfabilityquality!=null&&majorabilitycultivationquality!=null)
			data = selfabilityquality.toString()+","+majorabilitycultivationquality.toString();
		else if(selfabilityquality!=null&&majorabilitycultivationquality==null)
			data = selfabilityquality.toString();
		else if(selfabilityquality==null&&majorabilitycultivationquality!=null)
			data = majorabilitycultivationquality.toString();
		session.setAttribute("data",data);
		return "redirect:/baseView/personal-ability.jsp";
	}

	@RequestMapping(value = "/saveSelfabilityquality")
	public void saveSelfabilityquality(Selfabilityquality selfabilityquality, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		selfabilityquality.setUserId(user.getUserId().toString());
		selfabilityquality.setIsDelete(Short.valueOf("0"));
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
		majorabilitycultivationquality.setUserId(user.getUserId().toString());
		majorabilitycultivationquality.setIsDelete(Short.valueOf("0"));
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
		surveySysService.deleteSelfabilityqualityByUserID(user.getUserId().toString());
		surveySysService.deleteMajorabilitycultivationqualityByUserID(user.getUserId().toString());
		return "redirect:/baseView/personal-ability.jsp";
	}
	
	
	
}
