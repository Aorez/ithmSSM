package com.aorez.service.impl;

import com.aorez.dao.UserDao;
import com.aorez.service.UserService;

public class UserServiceImpl2 implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao u) {
        this.userDao = u;
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl2 save");
        userDao.save();
    }
}
