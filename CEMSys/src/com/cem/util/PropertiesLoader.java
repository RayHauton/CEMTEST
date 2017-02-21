package com.cem.util;

import java.util.Properties;

public class PropertiesLoader{
	public static void loadProperties(Properties properties,String propFilePath){
		System.out.println(PropertiesLoader.class.getClassLoader().getResource(propFilePath));
	}
	public static void main(String[] args) {
		loadProperties(new Properties(), "config/pageShow.properties");
	}
}
