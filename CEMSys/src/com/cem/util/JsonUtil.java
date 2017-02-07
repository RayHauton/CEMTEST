package com.cem.util;

import java.util.ArrayList;
import java.util.List;


import com.cem.pojo.Major;

import net.sf.json.JSONArray;

/*
 * json生成工具类
 */
public class JsonUtil {
	public static String generatorJsonForMajors(List<Major> majors){
		if(majors!=null){
//			JSONArray jsonArray = new JSONArray();
			List<String> majorIds = new ArrayList<>(majors.size());
			for(Major major:majors){
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("majorId", major.getMajorId());
//				jsonObject.put("majorName", major.getMajorName());
//				jsonArray.put(major.getMajorId());
				majorIds.add(major.getMajorId());
			}
			return JSONArray.fromObject(majorIds).toString();
		}else{
			return "";
		}
	}
}
