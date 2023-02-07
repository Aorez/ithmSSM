package com.aorez.service.impl;

import com.aorez.dao.UserDao;
import com.aorez.service.UserService;

public class UserServiceImpl3_8 implements UserService {
    private UserDao userDao;

    public UserServiceImpl3_8() {

    }

    public UserServiceImpl3_8(UserDao u) {
        this.userDao = u;
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl3 save");
        userDao.save();
    }
}
