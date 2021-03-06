package com.cem.interceptor;

import com.cem.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by RayHauton on 2017/1/29.
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static Properties properties = null;
    private static String systemName = null;
//    private static String systemDomain = null;
    static{
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/allowURLs.properties"));
            systemName = (String) properties.get("system.name");
//            systemDomain = (String) properties.get("system.domain");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        System.out.println(url);
        String urlKey = properties.getProperty(url.substring(systemName.length()));
        if (urlKey != null) {
            return true;
        }
        //检验session是否含有用户信息
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
        	/*
        	 * 这个地方还是需要进行权限验证，感觉代码写糟了，，，，尴尬
        	 */
        	String privilege = url.contains("_adm")?"1":"0";
        	String role = user.getRole();
        	boolean allow=false;
        	if(role.equals("0")){//管理员直接放行，普通用户不行
        		if(role.equals(privilege)){
        			allow=true;
        		}else{
        			 request.getRequestDispatcher("/privilegeWarning.jsp").forward(request,response);
        		}
        	}else{
        		allow=true;
        	}
            return allow;
        }
        //代码执行到这里，说明用户尚未登录，需要登录验证
        request.setAttribute("toLogin","toLogin");
        request.getSession().setAttribute("willTo", url);
        request.getRequestDispatcher("/loginRedirect.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
    }
}
