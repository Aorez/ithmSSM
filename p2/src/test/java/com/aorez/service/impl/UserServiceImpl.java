package com.aorez.service.impl;

import com.aorez.dao.UserDao;
import com.aorez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.aorez.service.impl.UserServiceImpl" p:userDao-ref="userDao"/>
//@Component("userService")
@Service("userService")
//配置scope
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    //只写Autowired根据数据类型进行自动注入
//    @Autowired
    //加上Qualifier则根据bean id进行注入，要结合使用
//    @Qualifier("userDao")
    //相当于Autowired加Qualifier
    @Resource(name="userDao")
    private UserDao userDao;
    //注解的时候set方法可以不写
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //$引用applicationContext.xml中所导入的jdbc.properties中的jdbc.driver
//    @Value("driver")
    //也可以直接赋值
    @Value("${jdbc.driver}")
    private String driver;

    @PostConstruct
    public void init() {
        System.out.println("UserServiceImpl init start");
        System.out.println("UserServiceImpl init end");
    }

    @PreDestroy
    //如果设置为prototype，则不会执行该方法，要设置为singleton
    public void destroy() {
        System.out.println("UserServiceImpl destroy start");
        System.out.println("UserServiceImpl destroy end");
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl save start");
        System.out.println("driver " + driver);
        userDao.save();
        System.out.println("UserServiceImpl save end");
    }
}
