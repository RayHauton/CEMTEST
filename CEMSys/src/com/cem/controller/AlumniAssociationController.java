package com.cem.controller;

import java.io.File;
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

import com.cem.pojo.AlumniAssociation;
import com.cem.service.AlumniAssociationService;
import com.cem.util.ImageUtil;

/**
 * 
 * 校友会前端控制器
 * @author linhd
 *
 */
@Controller
@RequestMapping(value = "/alumiAssociation")
public class AlumniAssociationController {
	@Value("${file.path}")
	private String path;
	@Value("${visualPathValue}")
	private String visualPathValue;
	@Autowired
	private AlumniAssociationService alumniAssociationService;
	@RequestMapping(value = "/open")
	public ModelAndView open(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = open_adm(request, response);
		modelAndView.setViewName("baseView/alumni-association");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/open_adm")
	public ModelAndView open_adm(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("alumniAssoList",alumniAssociationService.findAll());
		modelAndView.setViewName("admin/AlumniAssociationSet");
		return modelAndView;
	}
	@RequestMapping(value = "/delete_adm")
	public String delete(@RequestParam Integer id) throws Exception{
		AlumniAssociation pojoInDB = alumniAssociationService.findById(id);
		pojoInDB.setIsDeleted("1");
		alumniAssociationService.merge(pojoInDB);
		return "redirect:open_adm";
	}
	
	@RequestMapping(value = "/update_adm")
	public String update(AlumniAssociation alumniAssociation,MultipartFile file) throws Exception{
		AlumniAssociation pojoInDB = alumniAssociationService.findById(alumniAssociation.getAlumniAssociationId());
		if(!(file.getSize()==0)){
			String oriName = file.getOriginalFilename();
			String newName = UUID.randomUUID()+oriName.substring(oriName.lastIndexOf("."));
			String targetPath = visualPathValue+"/alumniAssociationImg/"+newName;
			file.transferTo(new File(targetPath));
			alumniAssociation.setImg(newName);
			int[] sizeInfo = ImageUtil.getImageWidthAndHeight(file.getInputStream());
			alumniAssociation.setWidth(sizeInfo[0]);
			alumniAssociation.setHeight(sizeInfo[1]);
		}else{
			alumniAssociation.setImg(pojoInDB.getImg());
			alumniAssociation.setWidth(pojoInDB.getWidth());
			alumniAssociation.setHeight(pojoInDB.getHeight());
		}
		alumniAssociation.setIsDeleted("0");
		alumniAssociationService.merge(alumniAssociation);
		return "redirect:open_adm";
	}
	
	/**
	 * 添加校友会信息
	 * @param alumniAssociation
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insert_adm")
	public String addAlumniAssociation(AlumniAssociation alumniAssociation,MultipartFile file) throws Exception{
		String fileOriName = file.getOriginalFilename();
		String targetDirPath = visualPathValue+"/alumniAssociationImg/";
		File targetDirFile = new File(targetDirPath);
		if(!targetDirFile.exists()){
			targetDirFile.mkdirs();
		}
		String newName = UUID.randomUUID()+fileOriName.substring(fileOriName.lastIndexOf("."));
		file.transferTo(new File(targetDirPath+newName));
		alumniAssociation.setImg(newName);
		int[] sizeInfo = ImageUtil.getImageWidthAndHeight(file.getInputStream());
		alumniAssociation.setWidth(sizeInfo[0]);
		alumniAssociation.setHeight(sizeInfo[1]);
		alumniAssociation.setIsDeleted("0");
		alumniAssociationService.insert(alumniAssociation);
		return "redirect:open_adm";
	}
}


















