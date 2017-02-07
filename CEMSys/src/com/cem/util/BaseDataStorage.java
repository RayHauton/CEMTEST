package com.cem.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cem.dao.DegreeDao;
import com.cem.pojo.Degree;
@Component
public class BaseDataStorage {
	public static List<Degree> degrees = new ArrayList<>();
	@Autowired
	private DegreeDao degreeDao;
	public List<Degree> getDegrees() throws Exception{
		return degreeDao.findAll();
	}
}
