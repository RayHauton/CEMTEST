package com.cem.controller;

import com.cem.pojo.User;
import com.cem.service.UserService;
import com.cem.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by RayHauton on 2017/1/25.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录账号
     * @param response
     * @param request
     * @param session
     * @throws Exception
     */
    @RequestMapping(value = "/login")
    public void login(HttpServletResponse response, HttpServletRequest request, HttpSession session) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String loginMethod = request.getParameter("loginMethod");
        String password = request.getParameter("password");
        /*
        如果直接访问login.action，那么会报空指针异常，所以在此处检查，
        如果loginMethod是null 说明用户直接登录的login.action，而不是login.jsp
        login.action 是白名单里的不被拦截的url，所以会顺利到达loginController；
         */
        if (loginMethod != null && loginMethod.length() != 0) {
            //判断登录方式
            String checkMethod = RegexUtil.getLoginMethod(loginMethod);
            User user;
            if (checkMethod.equals("phone")) {
                //手机号登录
                user = userService.findUserByMobile(loginMethod);
            } else if (checkMethod.equals("email")) {
                //邮箱登录
                user = userService.finduserByEmail(loginMethod);
            } else if (checkMethod.equals("studNum")) {
                //学号登录
                user = userService.findUserByStudNum(loginMethod);
            } else {
                //用户名登录
                user = userService.findUserByUsername(loginMethod);
            }
            /*
            校验密码
             */
            if (user != null) {
                /**
                 * 说明用户存在
                 * 此时还有两种情况，
                 * 用户已经注册但是尚未通过管理员审核，
                 * 另外就是审核通过的合法用户,
                 * 0：尚未审核；
                 * 1:审核通过
                 * 2：审核未通过
                 */
            	if(user.getCheckOut().equals("1")){//审核通过
            		//用户审核通过
            		if (password.equals(user.getPassword())) {
            			session.setAttribute("user", user);
            			response.getWriter().write("succ");
            		} else {
            			response.getWriter().write("error");
            		}
            	}else if(user.getCheckOut().equals("0")){//尚未审核
            		response.getWriter().write("notCheck");
            	}else{//未通过审核
            		response.getWriter().write("notPass");
            	}
            } else {
                response.getWriter().write("notExist");
            }
        } else {
            //说明是直接访问的是login.action
            response.sendRedirect("./login/login.jsp");
        }

    }

    /**
     * 注销登录
     * @param session
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    public void logout(HttpSession session,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            response.getWriter().write("succ");
        }else{
            response.getWriter().write("error");
        }
    }
}

