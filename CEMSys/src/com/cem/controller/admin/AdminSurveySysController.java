package com.cem.controller.admin;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;
import com.cem.queryVO.AdminSurveyQueryVo;
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
	
	@Value("${defaultPageSize}")
	private Integer pageSizeDefault;
	
	@Autowired
	SurveySysService surveySysService;
	
	@RequestMapping(value = "/open_adm")
	public String open(){
		return "redirect:/admin/survey.jsp";
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search_adm")
	public String search(AdminSurveyQueryVo adminSurveyQueryVo,HttpServletRequest request) throws Exception {
		if (adminSurveyQueryVo.getPageIndex() == null) {
			adminSurveyQueryVo.setPageIndex(1);
		}
		if (adminSurveyQueryVo.getPageSize() == null) {
			adminSurveyQueryVo.setPageSize(pageSizeDefault);
		}
		int pageIndex = adminSurveyQueryVo.getPageIndex();
		int pageSize = adminSurveyQueryVo.getPageSize();
		//获取查询条件，题号与对应的得分
		List<Integer> list = adminSurveySysService.searchSMCondition(adminSurveyQueryVo);
		
		String userIds = "";
		//将所有获取到的userId拼接成字符串传到前台，便于查询
		for (int id : list) {
			userIds = userIds + id +","; 
		}
		int listNum = list.size();
		request.getSession().setAttribute("userIds", userIds);
		request.getSession().setAttribute("listNum", listNum);
		request.getSession().setAttribute("pageCount", listNum%pageSize==0?listNum/pageSize:listNum/pageSize+1);

		//截取当前页面的userId数
		int tempInt = pageIndex*pageSize;
		if(tempInt>list.size())	tempInt = list.size();
		list = list.subList((pageIndex-1)*pageSize,tempInt);
		
		List<User> userList = new ArrayList<User>();
		for (Integer integer : list) {
			User user = adminSurveySysService.searchUserByUserId(integer);
			userList.add(user);
		}
		
		request.getSession().setAttribute("userList", userList);
		request.getSession().setAttribute("adminSurveyQueryVo", adminSurveyQueryVo);
		
		return "redirect:/admin/survey.jsp";
	}
	
	
	@RequestMapping(value = "/exportToExcelAndDownload_adm")
	public void exportToExcelAndDownload(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String downloadPart = request.getParameter("downloadPart");//是否为下载查询到的部分，part表示只下载查询到的信息
		String part = request.getParameter("part");//获取导出部分，1表示第一张表，2表示第二张表，无表示全部导出
		String[] userIds = null;
		if(downloadPart == null)
			userIds=adminSurveySysService.searchAllUser();
		else if(downloadPart.equals("part")){
			String userIdtemp = (String) request.getSession().getAttribute("userIds");//获取查询到的所有用户信息
			userIds = userIdtemp.split(",");
		}
		List<User> userList = new ArrayList<User>();
		List<Selfabilityquality> sList = new ArrayList<Selfabilityquality>();
		List<Majorabilitycultivationquality> mList = new ArrayList<Majorabilitycultivationquality>();
		//根据userId查询User、Selfabilityquality和Majorabilitycultivationquality三个表，并将查询到的信息添加到list中，便于将信息写入Excel
		for (String string : userIds) {
			int userId = Integer.valueOf(string);
			User user = adminSurveySysService.searchUserByUserId(userId);
			userList.add(user);
			if(part==null){
				Selfabilityquality selfabilityquality  = surveySysService.SearchSelfabilityqualityByUserID(userId);
				Majorabilitycultivationquality majorabilitycultivationquality = surveySysService.SearchMajorabilitycultivationqualityByUserID(userId);
				sList.add(selfabilityquality);
				mList.add(majorabilitycultivationquality);
			}else if (part.equals("1")) {
				Selfabilityquality selfabilityquality = surveySysService.SearchSelfabilityqualityByUserID(userId);
				sList.add(selfabilityquality);
			}else if(part.equals("2")){
				Majorabilitycultivationquality majorabilitycultivationquality = surveySysService.SearchMajorabilitycultivationqualityByUserID(userId);
				mList.add(majorabilitycultivationquality);
			}
		}
		//将数据写入Excel
		adminSurveySysService.dataToExcel(userList,sList,mList,request);
		//下载Excel文件
		adminSurveySysService.download(request,response);
	}
	
	@RequestMapping(value = "/showSurveyDetail_adm")
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
		map.put("surveyData", data);
		String s = JSONArray.fromObject(map).toString();
		response.getWriter().write(s);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
	@RequestMapping(value = "/showUserDetail_adm")
	public void showUserDetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取前台传来的用户ID号
		int userID = Integer.valueOf(request.getParameter("userId"));
		System.out.println(userID);
		User user = adminSurveySysService.searchUserByUserId(userID);
		String userString = user.toStringView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("userData", userString);
		String s = JSONArray.fromObject(map).toString();
		response.getWriter().write(s);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	

}
