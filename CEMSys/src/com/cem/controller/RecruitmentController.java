package com.cem.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

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
	@Value("${visualPathValue}")
	private String visualPathValue;
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
		// String realPath = context.getRealPath(path) + "/" + filename;
		/*
		 * 解析文件名称前面的时间段，然后反推出目录
		 */
		String parseFileName = filename.substring(0, 10);
		String realPath = visualPathValue + "/recruitmentAttachments/" + parseFileName.substring(0, 4) + "/"
				+ parseFileName.substring(5, 7) + "/" + filename;
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
			os.flush();// 清空缓存区
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
		/*
		 * 文件最终按照月份进行管理
		 */
		String oriFileName = attachment.getOriginalFilename();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String pubDate = dateFormat.format(new Date());// 获取当前日期的字符串
		System.out.println(pubDate.substring(0, 4));
		System.out.println(pubDate.substring(5, 7));
		String targetPath = visualPathValue + "/recruitmentAttachments/" + pubDate.substring(0, 4) + "/"
				+ pubDate.substring(5, 7);// 精确到月
		// 目标存储路径未必存在所以要进行判断
		// File file = new File(targetPath);
		Path path = Paths.get(targetPath);
		if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			// 说明目标目录不存在,进行创建
			Files.createDirectories(path);
		}
		// 重新命名文件名称
		String newName = pubDate + "_" + UUID.randomUUID() + oriFileName.substring(oriFileName.lastIndexOf("."));// 利用*
																													// 分割时间与文件实际名称
		attachment.transferTo(Paths.get(targetPath, newName).toFile());
		recruitment.setAttachmentPath(newName);
		recruitment.setPublishDate(pubDate);
		recruitment.setIsDeleted("0");
		recruitmentService.insertRecruitment(recruitment);
		return "redirect:show.action";
	}
}
