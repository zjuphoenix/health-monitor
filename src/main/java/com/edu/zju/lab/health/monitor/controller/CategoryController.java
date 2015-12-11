package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/10/14.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    private String ipAddress = "10.13.81.181";
    private String port = "60129";
    @RequestMapping()
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("category");
        mv.addObject("userID",((User) request.getSession().getAttribute("user")).getId()+"");
        mv.addObject("ip",this.ipAddress);
        mv.addObject("port",this.port);
        return mv;
    }
    @RequestMapping("/save")
    @ResponseBody
    public int save( @RequestParam("ip") String ipAddress,@RequestParam("port") String port) {
        this.ipAddress = ipAddress;
        this.port = port;
        return 0;
    }
}
