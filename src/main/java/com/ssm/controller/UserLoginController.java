package com.ssm.controller;

import com.ssm.mapper.UserMapper;
import com.ssm.po.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class UserLoginController {
    @RequestMapping(value="/toLogin")
    public String toLogin(){
        return "login";
    }
    @PostMapping (value="/login")
    public String login(User user, Model model, HttpSession session){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User userFind = userMapper.findUserByName(user.getUsername());
        if(userFind!=null){
            if(userFind.getPassword().equals(user.getPassword())){
                session.setAttribute("user_session",user);
                return "redirect:userHome";
            }
        }
        model.addAttribute("msg", "用户名或密码错误，请重新输入！");
        return "login";
    }
    @RequestMapping("/userHome")
    public String home(){
        return "userhome";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:toLogin";
    }
}
