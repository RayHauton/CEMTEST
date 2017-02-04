package com.cem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by RayHauton on 2017/1/31.
 */
@Controller
@RequestMapping(value = "surveySys")
public class SurveySysController {
    @RequestMapping(value = "/open")
    public String open() throws Exception{
        return "redirect:/baseView/personal-ability.jsp";
    }
}

