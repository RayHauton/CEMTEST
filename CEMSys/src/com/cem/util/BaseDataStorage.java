package com.cem.util;

import java.util.List;

import com.cem.daoImpl.DegreeDaoImpl;
import com.cem.pojo.Degree;

public class BaseDataStorage {
	public static List<Degree> degrees;
	static {
		try {
			degrees = new DegreeDaoImpl().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Degree> getDegrees() {
		return degrees;
	}
}
