package com.cem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by RayHauton on 2017/1/29.
 */
@Controller
@RequestMapping(value = "/infoSys")
public class BaseInfomationController {
    @RequestMapping(value = "/open")
    public String open() throws Exception{
        return "redirect:/baseView/base-information.jsp";
    }
}
