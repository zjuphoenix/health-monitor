package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.dao.UserMapper;
import com.edu.zju.lab.health.monitor.entity.User;
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
import java.io.IOException;

/**
 * Created by Administrator on 2015/10/14.
 */
@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping({ "", "/index", "/login"})
    public ModelAndView index(HttpServletRequest request) {
        if(request.getSession().getAttribute("user")instanceof User) {
            ModelAndView mv = new ModelAndView();
//            mv.addObject("userID",((User) request.getSession().getAttribute("user")).getId()+"");
            mv.setView(new RedirectView("category", false));
            return mv;
        }
        else return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, @RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password, HttpServletResponse response) throws IOException {
        if(userMapper.getUserByName(username)==null){
            //throw new ServiceException("用户名不存在");
            response.getWriter().write("<script>alert('用户名不存在！');</script>");
            return new ModelAndView("login");
        }
        else if(!(userMapper.getUserByName(username).getPassword().equals(password))){
            //throw new ServiceException("密码输入错误");
            response.getWriter().write("<script>alert('密码输入错误！');</script>");
            return new ModelAndView("login");
        }
        else {
            HttpSession session=request.getSession();
            session.setAttribute("user",userMapper.getUserByName(username));
            ModelAndView mv = new ModelAndView();
//            mv.addObject("userID",((User)session.getAttribute("user")).getId()+"");
            mv.setView(new RedirectView("category", false));
            return mv;
        }
    }

    @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, @RequestParam(value = "username") String username, @RequestParam(value = "tel") String tel,
                              @RequestParam(value = "password") String password, HttpServletResponse response) throws IOException {
        if(userMapper.getUserByName(username)!=null){
            response.getWriter().write("<script>alert('用户名已占用！');</script>");
            return new ModelAndView("register");
        }
        else{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setTel(tel);
            userMapper.insert(user);
            response.getWriter().write("<script>alert('注册成功！');</script>");
            return new ModelAndView("login");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
