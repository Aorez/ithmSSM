package com.aorez.service.impl;

import com.aorez.dao.UserDao;
import com.aorez.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("UserServiceImpl save");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao user = (UserDao) app.getBean("userDao");
        user.save();
    }
}
