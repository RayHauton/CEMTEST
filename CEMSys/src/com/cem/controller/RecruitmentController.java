package com.cem.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cem.globalException.GlobalCustomException;
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
	 * 招聘信息附件下载
	 */
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "filename") String filename) throws GlobalCustomException {
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath(path) + "/" + filename;
		System.out.println(realPath);
		response.setContentType("application/force-download");
		response.addHeader("Content-Disposition", "attachment;fileName=" + filename);
		/*
		 * 创建io组件
		 */
		File file = new File(realPath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		// 定义缓冲区
		byte[] buffer = new byte[1024];
		try {
			OutputStream os = response.getOutputStream();
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			int bound = bis.read(buffer);
			while (bound != -1) {
				os.write(buffer, 0, bound);
				bound = bis.read(buffer);
			}
			os.flush();//清空缓存区
		} catch (Exception ex) {
			throw new GlobalCustomException("IO异常");
		} finally {
			// 关闭资源

			try {
				if (bis != null) {
					bis.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 获取招聘信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/show")
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			RecruitmentQueryVo queryVo) throws Exception {
		/*
		 * 判断queryVo是否含有pageIndex和pageSize值，没有提供默认值 默认值的设置在配置文件中设置
		 */
		if (queryVo.getPageIndex() == null) {
			queryVo.setPageIndex(1);
		}
		if (queryVo.getPageSize() == null) {
			queryVo.setPageSize(pageSizeDefault);
		}
		ModelAndView modelAndView = new ModelAndView();
		/*
		 * 调用service获取查询结果
		 */
		Map<String, Object> queryResult = recruitmentService.findAll(queryVo);
		modelAndView.addObject("recruitmentList", queryResult.get("resultList"));
		/*
		 * 设置总记录数 不用list.size()查询记录数是因为耗内存；
		 */
		int recordCount = (int) queryResult.get("recordCount");
		queryVo.setRecordCount(recordCount);
		/*
		 * 设置总页数
		 */
		int pageSize = queryVo.getPageSize();
		/*
		 * 确定总页数用于前台展现
		 */
		queryVo.setPageCount(recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1);
		/*
		 * 向modelAndView填充数据
		 */
		modelAndView.addObject("queryVo", queryVo);
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
		// System.out.println(pageSizeString);
		/*
		 * 文件默认放在/WebRoot/fileUpload文件夹中 最后项目完成更换成服务器的某个位置 这个地方
		 * 尽管请求完毕后项目中的fileUpload目录仍然是空的 但是在tomcat的项目目录文件已经成功上传
		 */
		String oriFileName = attachment.getOriginalFilename();
		if (oriFileName != null && oriFileName.length() != 0 && attachment != null) {
			// 用户可能不上传附件
			String newFileName = UUID.randomUUID() + oriFileName.substring(oriFileName.lastIndexOf("."));
			File newFile = new File(dirRealPath + "/" + newFileName);
			attachment.transferTo(newFile);
			recruitment.setAttachmentPath(newFileName);
		}
		recruitment.setPublishDate(new java.sql.Date(new java.util.Date().getTime()));
		recruitment.setIsDeleted("0");
		recruitmentService.insertRecruitment(recruitment);
		return "redirect:show.action";
	}
}
