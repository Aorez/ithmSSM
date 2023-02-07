package com.aorez.dao.impl;

import com.aorez.dao.UserDao;
import com.aorez.domain.User3_8;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl3_8 implements UserDao {
    private List<String> strings;
    private Map<String, User3_8> userMap;
    private Properties properties;

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public void setUserMap(Map<String, User3_8> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println("UserDaoImpl3_8 save");
        System.out.println(strings);
        System.out.println(userMap);
        System.out.println(properties);
    }
}
