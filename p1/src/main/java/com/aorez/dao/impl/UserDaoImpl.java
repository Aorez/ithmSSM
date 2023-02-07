package com.aorez.dao.impl;

import com.aorez.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl无参构造方法调用");
    }

    public void init() {
        System.out.println("UserDaoImpl init");
    }

    public void destroy() {
        System.out.println("UserDaoImpl destroy");
    }

    @Override
    public void save() {
        System.out.println("UserDaoImpl save");
    }
}
