package com.aorez.service.impl;

import com.aorez.dao.UserDao;
import com.aorez.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl save start");
        userDao.save();
        System.out.println("UserServiceImpl save end");
    }
}
