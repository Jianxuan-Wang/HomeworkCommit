package com.ssm.controller;

import com.ssm.mapper.UserMapper;
import com.ssm.po.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRegisterController {
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String userRegister(User user, Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User userFind = userMapper.findUserByName(user.getUsername());
        if(userFind!=null){
            model.addAttribute("msg","用户名已存在！");
            return "register";
        }
        int n = userMapper.addUser(user);
        if(n>0){
            model.addAttribute("msg","用户"+user.getUsername()+"创建成功！");
            return "login";
        }
        model.addAttribute("msg","用户创建失败！");
        return "login";
    }
}
