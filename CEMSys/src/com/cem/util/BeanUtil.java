package com.cem.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtil {
	private static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
	}
	public static Object getBean(Class<?> clazz){
		return context.getBean(clazz);
	}
}
