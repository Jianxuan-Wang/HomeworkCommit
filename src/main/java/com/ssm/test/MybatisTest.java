package com.ssm.test;

import com.ssm.mapper.UserMapper;
import com.ssm.po.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisTest {
    @Test
    public void findUserById2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.findUserByName("wjx");
        System.out.println(user.toString());
    }
    @Test
    public void addUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        int n = userMapper.addUser(new User("llw","1234"));
        System.out.println(n);
    }
}
