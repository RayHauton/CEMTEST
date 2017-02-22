package com.cem.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cem.pojo.Recruitment;
import com.cem.queryVO.RecruitmentQueryVo;
import com.cem.service.RecruitmentService;

@Controller
@RequestMapping(value = "/recruitment")
public class RecruitmentController {
	@Value("${file.path}")
	private String path;
	@Value("${defaultPageSize}")
	private Integer pageSizeDefault;
	@Autowired
	private RecruitmentService recruitmentService;
	
	/*
	 * 打开发布招聘信息界面
	 */
	@RequestMapping(value = "/open")
	public void open(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 使用转发避免，使用重定向会暴露静态资源地址
		 */
		request.getRequestDispatcher("/baseView/recruitment_pub.jsp").forward(request, response);
	}

	/*
	 * 获取招聘信息
	 */
	@RequestMapping(value = "/show")
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session,
			RecruitmentQueryVo queryVo) throws Exception {
		int pageIndex = (queryVo.getPageIndex()==null)?1:queryVo.getPageIndex();
		int pageSize = queryVo.getPageSize()==null?pageSizeDefault:queryVo.getPageSize();
		String searchCondition = queryVo.getQueryCondition();
		ModelAndView modelAndView = new ModelAndView();
		List<Recruitment> queryResult = null;
		if(searchCondition!=null){
			
		}else{
			queryResult=recruitmentService.findAllWithDivPage(pageIndex, pageSize);
		}
		modelAndView.addObject("recruitmentList",queryResult);
		/*
		 * 设置当前页码
		 */
		queryVo.setPageIndex(pageIndex);
		/*
		 * 设置总记录数
		 */
		int recordCount = queryResult.size();
		queryVo.setRecordCount(recordCount);
		/*
		 * 设置总页数
		 */
		queryVo.setPageCount(recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1);
		modelAndView.addObject("queryVo",queryVo);
		modelAndView.setViewName("baseView/recruitment_show");
		return modelAndView;
	}

	/*
	 * 发布招聘信息
	 */
	@RequestMapping("/publish")
	public String publish(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			MultipartFile attachment, Recruitment recruitment) throws Exception {
		ServletContext context = request.getServletContext();
		String dirRealPath = context.getRealPath(path);
		System.out.println(dirRealPath);
//		System.out.println(pageSizeString);
		/*
		 * 文件默认放在/WebRoot/fileUpload文件夹中 最后项目完成更换成服务器的某个位置 这个地方
		 * 尽管请求完毕后项目中的fileUpload目录仍然是空的 但是在tomcat的项目目录文件已经成功上传
		 */
		String oriFileName = attachment.getOriginalFilename();
		if (attachment != null) {
			// 用户可能不上传附件
			String newFileName = UUID.randomUUID() + oriFileName.substring(oriFileName.lastIndexOf("."));
			File newFile = new File(dirRealPath + "/" + newFileName);
			attachment.transferTo(newFile);
			recruitment.setAttachmentPath(newFileName);
		}
		recruitment.setPublishDate(new Timestamp(new java.util.Date().getTime()));
		recruitment.setIsDeleted("0");
		recruitmentService.insertRecruitment(recruitment);
//		response.getWriter().write("succ");
		return "redirect:show.action";
	}
}
