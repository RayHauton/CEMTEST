package com.cem.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private String visualPathValue;// tomcat虚拟路径对应的真实路径
	@Value("${defaultPageSize}")
	private Integer pageSizeDefault;
	@Autowired
	private CollegeEventService collegeEventService;

	@RequestMapping(value = "/loadImg")
	public void loadImg(@RequestParam Integer eventId,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(collegeEventService.findById(eventId).getEventImg());
	}
	/*
	 * 加载事件详细信息以及事件标题
	 */
	@RequestMapping(value = "/findInfo")
	public void findInfo(@RequestParam Integer eventId,@RequestParam Integer flag,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		if(flag==1){
			response.getWriter().write(collegeEventService.findById(eventId).getEventDetail());
		}else{
			response.getWriter().write(collegeEventService.findById(eventId).getEventTitle());
		}
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestParam Integer eventId,HttpServletResponse response) throws Exception{
		Collegeevent persist = collegeEventService.findById(eventId);
		persist.setIsDeleted("1");
		collegeEventService.merge(persist);
		response.getWriter().write("succ");
	}
	
	@RequestMapping(value = "/update")
	public String update(Collegeevent colgevnt, MultipartFile image, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * 首先根据ID查询出对应事件记录
		 */
		Collegeevent persist = collegeEventService.findById(colgevnt.getEventId());
		/*
		 * 判断图片是否上传，如果没有上传说明用户
		 * 尚未修改图片，只是修改了其他信息，通过image的size来判断
		 */
		if(image.getSize()==0){
			/*
			 * 说明用户没有修改图片。
			 * 此时还分两种情况，如果用户更改了事件的时间，那么对应文件也要移动位置到指定目录
			 * （因为文件的存储是按照年份来存取的，时间变更，文件位置联动更改）
			 */
			String oriDate = persist.getEventDate().substring(0,4);
			String newDate = colgevnt.getEventDate().substring(0,4);
			if(!oriDate.equals(newDate)){
				//说明年份发生变更，此时文件需要移动
				String targetPath = visualPathValue+"/collegeEventImgs/"+newDate;
				String oriFilePath = visualPathValue+"/collegeEventImgs/"+persist.getEventImg();
				File oldFile = new File(oriFilePath);
				File file = new File(targetPath);
				if(!file.exists()){
					file.mkdirs();
				}
				if(oldFile.renameTo(new File(targetPath+"/"+persist.getEventImg().substring(5)))){
					System.out.println("***************success*****************");
				}
				colgevnt.setEventImg(newDate+"/"+persist.getEventImg().substring(5));
			}else{
				colgevnt.setEventImg(persist.getEventImg());
			}
		}else{
			//说明用户更改了图片，此时删除原有的图片，写入新的图片
			File file = new File(visualPathValue+"/collegeEventImgs/"+persist.getEventImg());
			file.delete();//删除原有图片
			/*
			 * 写入新的图片
			 */
			String date = colgevnt.getEventDate().substring(0,4);
			String oriName = image.getOriginalFilename();
			String targetPath = visualPathValue+"/collegeEventImgs/"+date;
			file = new File(targetPath);
			if(!file.exists()){
				file.mkdirs();//如果不存在目标目录，创建之
			}
			String newName = UUID.randomUUID()+oriName.substring(oriName.lastIndexOf("."));
			image.transferTo(new File(targetPath+"/"+newName));
			colgevnt.setEventImg(date+"/"+newName);
		}
		/*
		 * 设置标志位信息
		 */
		colgevnt.setIsDeleted("0");
		//执行更新操作
		collegeEventService.merge(colgevnt);
//		response.getWriter().write("succ");
		return "redirect:show_adm";
	}

	@RequestMapping(value = "/add")
	public String add(Collegeevent colgevnt, MultipartFile image, HttpServletRequest request) throws Exception {
		String oriName = image.getOriginalFilename();
		// String dirRealPath =
		// request.getSession().getServletContext().getRealPath(path);//获取真实物理路径
		/*
		 * 根据事件日期创建相应目录进行分级存放文件
		 */
		String date = colgevnt.getEventDate();
		String dirName = date.substring(0, 4);// 截取年份，用年份来创建目录,原始数据格式为yyyy-MM
		/*
		 * 判断目标目录是否存在，不存在创建之
		 */
		String targetPath = visualPathValue + "/collegeEventImgs/" + dirName;
		File targetDir = new File(targetPath);
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		String newName = UUID.randomUUID() + oriName.substring(oriName.lastIndexOf("."));
		image.transferTo(new File(targetPath + "/" + newName));
		colgevnt.setEventImg(dirName + "/" + newName);// 设置pojo的文件路径
		// colgevnt.setIsDeleted("0");
		/*
		 * 调用service进行存储
		 */
		collegeEventService.add(colgevnt);
		return "redirect:show_adm";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/show_adm")
	public ModelAndView show_adm(CollegeEventQueryVo queryVo, HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		// String rootDir = request.getServletContext().getRealPath(path);
		Map<String, Object> resultMap = collegeEventService.findAll(queryVo);
		int recordCount = (Integer) resultMap.get("recordCount");
		int pageSize = queryVo.getPageSize();
		queryVo.setRecordCount(recordCount);
		queryVo.setPageCount(recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1);
		modelAndView.addObject("resultList", (List<Collegeevent>) resultMap.get("resultList"));
		// modelAndView.addObject("rootDir", rootDir+"/");
		modelAndView.addObject("queryVo", queryVo);
		modelAndView.setViewName("admin/collegeEventSet");
		return modelAndView;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/show")
	public ModelAndView show(CollegeEventQueryVo queryVo, HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		// String rootDir = request.getServletContext().getRealPath(path);
		Map<String, Object> resultMap = collegeEventService.findAll(queryVo);
		int recordCount = (Integer) resultMap.get("recordCount");
		int pageSize = queryVo.getPageSize();
		queryVo.setRecordCount(recordCount);
		queryVo.setPageCount(recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1);
		modelAndView.addObject("resultList", (List<Collegeevent>) resultMap.get("resultList"));
		// modelAndView.addObject("rootDir", rootDir+"/");
		modelAndView.addObject("queryVo", queryVo);
		modelAndView.setViewName("baseView/timeline");
		return modelAndView;
	}
}
