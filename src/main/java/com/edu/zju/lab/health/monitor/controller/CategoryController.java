package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/10/14.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @RequestMapping()
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("category");
        mv.addObject("userID",((User) request.getSession().getAttribute("user")).getId()+"");
        return mv;
    }
}
