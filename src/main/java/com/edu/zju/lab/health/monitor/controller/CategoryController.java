package com.edu.zju.lab.health.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2015/10/14.
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @RequestMapping()
    public ModelAndView index() {
        return new ModelAndView("category");
    }
}
