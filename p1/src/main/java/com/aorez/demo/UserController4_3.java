package com.aorez.demo;

import com.aorez.domain.User3_8;
import com.aorez.service.UserService;
import com.aorez.service.impl.UserServiceImpl3_8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController4_3 {
    public static void main(String[] args) {
        //测试getBean方法
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //由于applicationContext.xml中有两个User3_8的标签，所以冲突，报错
//        User3_8 user = app.getBean(User3_8.class);
//        System.out.println(user);
        UserServiceImpl3_8 userServiceImpl = app.getBean(UserServiceImpl3_8.class);
        userServiceImpl.save();
    }
}
