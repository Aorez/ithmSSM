package com.aorez.dao.impl;

import com.aorez.dao.UserDao;

public class UserDaoImpl3 implements UserDao {
    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println("UserDaoImpl3 save");
        System.out.println("username" + username);
        System.out.println("age" + age);
    }
}
