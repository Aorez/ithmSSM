package com.aorez.factory;

import com.aorez.dao.UserDao;
import com.aorez.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
