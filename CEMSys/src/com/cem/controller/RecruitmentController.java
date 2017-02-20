package com.cem.controller;

import java.io.File;
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
	@Value("${show.pageSize}")
	private String pageSizeString;
	@Value("${show.pageSize.default}")
	private Integer pageSizeDefault;
	private List<Integer> pageSizeList;
	@Autowired
	private RecruitmentService recruitmentService;

	{
		String[] pageSizeArray = pageSizeString.split(".");
		for(String item:pageSizeArray){
			pageSizeList.add(Integer.parseInt(item));
		}
	}
	
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
			RecruitmentQueryVo recruitmentQueryVo) throws Exception {
		int pageIndex = (recruitmentQueryVo.getPageIndex()==null)?1:recruitmentQueryVo.getPageIndex();
		int pageSize = recruitmentQueryVo.getPageSize()==null?pageSizeDefault:recruitmentQueryVo.getPageSize();
		String searchCondition = recruitmentQueryVo.getQueryCondition();
		ModelAndView modelAndView = new ModelAndView();
		if(searchCondition!=null){
			
		}else{
			modelAndView.addObject("recruitmentList",recruitmentService.findAll(pageIndex, pageSize));
		}
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
		recruitment.setPublishDate(new java.sql.Date(new java.util.Date().getTime()));
		recruitment.setIsDeleted("0");
		recruitmentService.insertRecruitment(recruitment);
//		response.getWriter().write("succ");
		return "/show.action";
	}
}
