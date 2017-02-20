package com.cem.globalException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalCustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		GlobalCustomException customException = null;
		if(ex instanceof GlobalCustomException){
			customException = (GlobalCustomException) ex;
		}else{
			customException = new GlobalCustomException("未知错误");
		}
		String message = customException.getMessage();
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ex.printStackTrace(new PrintWriter(buf,true));
		String stackTrace = buf.toString();
		try {
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.addObject("stackTrace",stackTrace);
		modelAndView.setViewName("/error");
		return modelAndView;
	}

}
