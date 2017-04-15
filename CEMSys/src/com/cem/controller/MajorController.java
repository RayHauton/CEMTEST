package com.cem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cem.customPojo.MajorCustom;
import com.cem.pojo.Major;
import com.cem.pojo.Schoolexperience;
import com.cem.service.MajorService;
import com.cem.service.SchoolExperienceService;
import com.cem.util.PrimaryGenerateUtil;

@Controller
@RequestMapping(value = "/majorSet")
public class MajorController {
	@Autowired
	private MajorService majorService;
	@Autowired
	private SchoolExperienceService schoolExperienceService;
	
	@RequestMapping(value = "/insert_adm")
	public String insertMajor(MajorCustom majorCustom,String[] degreeId_add) throws Exception{
		Major newMajor = new Major();
		String newKey = PrimaryGenerateUtil.generateForMajorTable(majorService.findMaxId());
		newMajor.setMajorId(newKey);
		newMajor.setMajorName(majorCustom.getMajorName());
		newMajor.setIsDeleted("0");
		//创建SchoolExperience
		Schoolexperience se = null;
		String maxSeId = schoolExperienceService.findMaxId();
		String newSeKey = PrimaryGenerateUtil.generateForSchoolexperienceTable(maxSeId);
		List<Schoolexperience> seList = new ArrayList<>();
		for(String degreeId:degreeId_add){
			se = new Schoolexperience();
			se.setSchooleExperienceId(newSeKey);
			se.setDegreeId(degreeId);
			se.setMajorId(newMajor.getMajorId());
			se.setIsDeleted("0");
			seList.add(se);
			newSeKey = PrimaryGenerateUtil.generateForSchoolexperienceTable(newSeKey);
		}
		majorService.insert(newMajor);
		schoolExperienceService.insertSEBatch(seList);
		return "redirect:open_adm";
	}
	
	
	@RequestMapping(value = "/open_adm")
	public ModelAndView open_adm() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("majorCustomList", majorService.findAllWithDegreeInfo());
		modelAndView.setViewName("admin/majorSet");
		return modelAndView;
	}
	
	
}
