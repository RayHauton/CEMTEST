package com.cem.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cem.pojo.Collegeevent;
import com.cem.queryVO.CollegeEventQueryVo;
import com.cem.service.CollegeEventService;

/*
 * 学院事件录Controller
 */
@Controller
@RequestMapping(value = "/collegeEvent")
public class CollegeEventController {
	@Value("${file.path}")
	private String path;
	@Value("${visualPathValue}")
	private String visualPathValue;//tomcat虚拟路径对应的真实路径
	@Value("${defaultPageSize}")
	private Integer pageSizeDefault;
	@Autowired
	private CollegeEventService collegeEventService;
	@RequestMapping(value="/add")
	public void add(Collegeevent colgevnt,MultipartFile image,HttpServletRequest request) throws Exception{
		String oriName = image.getOriginalFilename();
//		String dirRealPath = request.getSession().getServletContext().getRealPath(path);//获取真实物理路径
		/*
		 * 根据事件日期创建相应目录进行分级存放文件
		 */
		String date = colgevnt.getEventDate();
		String dirName = date.substring(0,4);//截取年份，用年份来创建目录,原始数据格式为yyyy-MM
		/*
		 * 判断目标目录是否存在，不存在创建之
		 */
		String targetPath = visualPathValue+"/collegeEventImgs/"+dirName;
		File targetDir = new File(targetPath);
		if(!targetDir.exists()){
			targetDir.mkdirs();
		}
		String newName = UUID.randomUUID()+oriName.substring(oriName.lastIndexOf("."));
		image.transferTo(new File(targetPath+"/"+newName));
		colgevnt.setEventImg(dirName+"/"+newName);//设置pojo的文件路径
//		colgevnt.setIsDeleted("0");
		/*
		 * 调用service进行存储
		 */
		collegeEventService.add(colgevnt);
	}
	
	@RequestMapping(value = "/show_adm")
	public ModelAndView show_adm() throws Exception{
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.setViewName("admin/collegeEventSet");
		return modelAndView;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/show")
	public ModelAndView show(CollegeEventQueryVo queryVo,HttpServletRequest request) throws Exception{
		ModelAndView modelAndView  = new ModelAndView();
		String rootDir = request.getServletContext().getRealPath(path);
		Map<String,Object> resultMap = collegeEventService.findAll(queryVo);
		int recordCount=(Integer) resultMap.get("recordCount");
		int pageSize = queryVo.getPageSize();
		queryVo.setRecordCount(recordCount);
		queryVo.setPageCount(recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1);
		modelAndView.addObject("resultList",(List<Collegeevent>)resultMap.get("resultList"));
		modelAndView.addObject("rootDir", rootDir+"/");
		modelAndView.addObject("queryVo",queryVo);
		modelAndView.setViewName("baseView/timeline");
		return modelAndView;
	}
}
