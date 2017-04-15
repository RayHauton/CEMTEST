package com.cem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cem.customPojo.MajorCustom;
import com.cem.pojo.Major;
import com.cem.pojo.Schoolexperience;
import com.cem.service.MajorService;
import com.cem.service.SchoolExperienceService;
import com.cem.util.PrimaryKeyGenerateUtil;

@Controller
@RequestMapping(value = "/majorSet")
public class MajorController {
	@Autowired
	private MajorService majorService;
	@Autowired
	private SchoolExperienceService schoolExperienceService;
	
	@RequestMapping(value = "/delete_adm")
	public String delete_adm(String majorId) throws Exception{
		Major majorPersis = majorService.findByMajorId(majorId);
		majorPersis.setIsDeleted("1");
		majorService.merge(majorPersis);
		//级联修改schoolexperience表
		List<Schoolexperience> seList = schoolExperienceService.findSEByMajorId(majorId);
		for(Schoolexperience se:seList){
			se.setIsDeleted("0");
			schoolExperienceService.update(se);
		}
		return "redirect:open_adm";
	}
	
	
	
	@RequestMapping(value = "/update_adm")
	public String merge(Major major,String[] degreeId_update) throws Exception{
		Major majorPersis = majorService.findByMajorId(major.getMajorId());
		majorPersis.setMajorName(major.getMajorName());
//		majorService.merge(majorPersis);
		List<String> degreeIdsFront = Arrays.asList(degreeId_update);
		List<String> degreeIdsPersis = schoolExperienceService.findDegreeIdByMajorId(major.getMajorId());
		List<Object> common = new ArrayList<>();
		for(String degreeIdPersis:degreeIdsPersis){
			if(!degreeIdsFront.contains(degreeIdPersis)){
				//说明这个专业对应的这个学位已经被删掉
				System.out.println("删除："+degreeIdPersis);
				Schoolexperience seDel = schoolExperienceService.findSchoolExperienceByMajorIdAndDegreeId(degreeIdPersis,major.getMajorId());
				seDel.setIsDeleted("1");
				schoolExperienceService.update(seDel);
			}else{
				common.add(degreeIdPersis);
			}
		}
		String maxSeId = schoolExperienceService.findMaxId();
		String newSeKey = PrimaryKeyGenerateUtil.generateForSchoolexperienceTable(maxSeId);
		List<Schoolexperience> insertList = new ArrayList<Schoolexperience>();
		for(String degreeIdFront:degreeIdsFront){
			if(!common.contains(degreeIdFront)){
				//添加学历信息
				System.out.println("添加："+degreeIdFront);
				Schoolexperience seAdd = new Schoolexperience();
				seAdd.setSchooleExperienceId(newSeKey);
				seAdd.setDegreeId(degreeIdFront);
				seAdd.setMajorId(major.getMajorId());
				seAdd.setIsDeleted("0");
				insertList.add(seAdd);
				newSeKey = PrimaryKeyGenerateUtil.generateForSchoolexperienceTable(newSeKey);
			}
		}
		schoolExperienceService.insertSEBatch(insertList);
		return "redirect:open_adm";
	}
	
	@RequestMapping(value = "/getDegreeIdByMajorId")
	public void getDegreeIdByMajorId(String majorId,HttpServletRequest request,HttpServletResponse response) throws Exception{
		StringBuffer degreeString = new StringBuffer();
		List<String> degreeIds = schoolExperienceService.findDegreeIdByMajorId(majorId);
		for(String degreeId:degreeIds){
			degreeString.append(degreeId+"|");
		}
		
		response.getWriter().write(degreeString.substring(0,degreeString.length()-1));//去除最后一个多余的“|”符号
	}
	
	
	@RequestMapping(value = "/insert_adm")
	public String insertMajor(MajorCustom majorCustom,String[] degreeId_add) throws Exception{
		Major newMajor = new Major();
		String newKey = PrimaryKeyGenerateUtil.generateForMajorTable(majorService.findMaxId());
		newMajor.setMajorId(newKey);
		newMajor.setMajorName(majorCustom.getMajorName());
		newMajor.setIsDeleted("0");
		//创建SchoolExperience
		Schoolexperience se = null;
		String maxSeId = schoolExperienceService.findMaxId();
		String newSeKey = PrimaryKeyGenerateUtil.generateForSchoolexperienceTable(maxSeId);
		List<Schoolexperience> seList = new ArrayList<>();
		for(String degreeId:degreeId_add){
			se = new Schoolexperience();
			se.setSchooleExperienceId(newSeKey);
			se.setDegreeId(degreeId);
			se.setMajorId(newMajor.getMajorId());
			se.setIsDeleted("0");
			seList.add(se);
			newSeKey = PrimaryKeyGenerateUtil.generateForSchoolexperienceTable(newSeKey);
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
