package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.dao.UserMapper;
import com.edu.zju.lab.health.monitor.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/10/14.
 */
@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping({ "", "/index", "/login"})
    public ModelAndView index() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, @RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password, HttpServletResponse response) {
        if(userMapper.getUserByName(username)==null){
            throw new ServiceException("用户名不存在");
        }
        else if(!(userMapper.getUserByName(username).getPassword().equals(password))){
            throw new ServiceException("密码输入错误");
        }
        else {
            HttpSession session=request.getSession();
            session.setAttribute("user",userMapper.getUserByName(username));
            ModelAndView mv = new ModelAndView();
            mv.setView(new RedirectView("category", false));
            return mv;
        }
    }

    @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
