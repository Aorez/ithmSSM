package com.aorez.factory;

import com.aorez.dao.UserDao;
import com.aorez.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
