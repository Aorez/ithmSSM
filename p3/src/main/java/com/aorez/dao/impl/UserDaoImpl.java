package com.aorez.dao.impl;

import com.aorez.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl save start");
        System.out.println("UserDaoImpl save end");
    }
}
