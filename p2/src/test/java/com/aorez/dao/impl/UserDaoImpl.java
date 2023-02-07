package com.aorez.dao.impl;

import com.aorez.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


//<bean id="userDao" class="com.aorez.dao.impl.UserDaoImpl"/>
//@Component("userDao")
//上下这两个是一样的，只是下面的可读性好
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl save start");
        System.out.println("UserDaoImpl save end");
    }
}
