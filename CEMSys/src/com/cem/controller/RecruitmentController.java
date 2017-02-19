package com.cem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cem.pojo.Recruitment;

@Controller
@RequestMapping(value = "/recruitment")
public class RecruitmentController {
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
	 * 发布招聘信息
	 */
	@RequestMapping("/publish")
	public void publish(HttpServletResponse response,
			HttpSession session,
			MultipartFile fileUpload,
			Recruitment attachment) {
		/*
		 * 文件默认放在/WebRoot/fileUpload文件夹中
		 * 最后项目完成更换成服务器的某个位置
		 */
		
	}
}















