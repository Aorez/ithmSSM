package com.aorez.dao.impl;

import com.aorez.dao.UserDao;

public class UserDaoImpl2 implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl2 save");
    }
}
