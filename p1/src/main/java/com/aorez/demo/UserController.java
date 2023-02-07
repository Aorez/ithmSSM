package com.aorez.demo;

import com.aorez.service.UserService;
import com.aorez.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        //一般的调用程序
//        UserService userService = new UserServiceImpl();
//        userService.save();

        //利用ApplicationContext
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
