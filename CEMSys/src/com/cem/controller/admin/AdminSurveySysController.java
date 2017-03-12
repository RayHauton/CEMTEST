package com.cem.controller.admin;

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
import com.cem.service.AdminSurveySysService;
import com.cem.service.SurveySysService;

import net.sf.json.JSONArray;
/**
 * 
 * @author nc硪fl
 *
 */
@Controller
@RequestMapping(value = "adminSurveySys")
public class AdminSurveySysController {
	@Autowired
	AdminSurveySysService adminSurveySysService;
	
	@Autowired
	SurveySysService surveySysService;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search")
	public String search(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
		//获取查询条件，题号与对应的得分
		String[] titleNum = request.getParameterValues("titleNum");
		String[] scoreNum = request.getParameterValues("scoreNum");
		List<Integer> list = adminSurveySysService.searchSMCondition(titleNum, scoreNum);
		List<User> userList = new ArrayList<User>();
		for (Integer integer : list) {
			User user = adminSurveySysService.searchUserByUserId(integer);
			System.out.println(user);
			userList.add(user);
		}
		
		request.getSession().setAttribute("userList", userList);
		request.getSession().setAttribute("listNum", list.size());
		
		String userIds = "";
		//将所有获取到的userId拼接成字符串传到前台，便于查询
		for (User user : userList) {
			userIds = userIds + user.getUserId()+","; 
		}
		request.getSession().setAttribute("userIds", userIds);
		return "redirect:/admin/survey.jsp";
	}
	
	
	@RequestMapping(value = "/exportToExcelAndDownload")
	public void exportToExcelAndDownload(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception{
		String userIdtemp = request.getParameter("userIds");
		String[] userIds = null;
		if(userIdtemp != null)
			userIds = userIdtemp.split(",");
		if(userIdtemp == null){
			userIds=adminSurveySysService.searchAllUser();
		}
		List<User> userList = new ArrayList<User>();
		List<Selfabilityquality> sList = new ArrayList<Selfabilityquality>();
		List<Majorabilitycultivationquality> mList = new ArrayList<Majorabilitycultivationquality>();
		//根据userId查询User、Selfabilityquality和Majorabilitycultivationquality三个表，并将查询到的信息添加到list中，便于将信息写入Excel
		for (String string : userIds) {
			int userId = Integer.valueOf(string);
			User user = adminSurveySysService.searchUserByUserId(userId);
			Selfabilityquality selfabilityquality  = surveySysService.SearchSelfabilityqualityByUserID(userId);
			Majorabilitycultivationquality majorabilitycultivationquality = surveySysService.SearchMajorabilitycultivationqualityByUserID(userId);
			userList.add(user);
			sList.add(selfabilityquality);
			mList.add(majorabilitycultivationquality);
		}
		//将数据写入Excel
		adminSurveySysService.dataToExcel(userList,sList,mList);
		//下载Excel文件
		adminSurveySysService.download();
	}
	
	@RequestMapping(value = "/showSurveyDetail")
	public void showSurveyDetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取前台传来的用户ID号
		int userID = Integer.valueOf(request.getParameter("userId"));
		//查询两个表中的记录
		Selfabilityquality selfabilityquality  = surveySysService.SearchSelfabilityqualityByUserID(userID);
		Majorabilitycultivationquality majorabilitycultivationquality = surveySysService.SearchMajorabilitycultivationqualityByUserID(userID);
		String data = null;
		//讲查询到的结构拼接成字符串
		if(selfabilityquality!=null&&majorabilitycultivationquality!=null)
			data = selfabilityquality.toString()+","+majorabilitycultivationquality.toString();
		else if(selfabilityquality!=null&&majorabilitycultivationquality==null)
			data = selfabilityquality.toString();
		else if(selfabilityquality==null&&majorabilitycultivationquality!=null)
			data = majorabilitycultivationquality.toString();
		//用map将拼接而成的字符串传给前台
		Map<String, String> map = new HashMap<String, String>();
		map.put("activityName", data);
		String s = JSONArray.fromObject(map).toString();
		response.getWriter().write(s);
		response.getWriter().flush();
		response.getWriter().close();
		System.out.println("over");
	}
	
	

}
