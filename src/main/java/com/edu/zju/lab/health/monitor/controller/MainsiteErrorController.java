package com.edu.zju.lab.health.monitor.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2015/10/26.
 */
@Controller
public class MainsiteErrorController implements ErrorController{
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public ModelAndView handleError(){
        return new ModelAndView("error");
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return ERROR_PATH;
    }
}
