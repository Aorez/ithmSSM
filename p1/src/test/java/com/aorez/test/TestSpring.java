package com.aorez.test;

import com.aorez.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    //测试Bean标签scope属性
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao user1 = (UserDao) app.getBean("userDao");
        UserDao user2 = (UserDao) app.getBean("userDao");
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    //测试init属性和destroy属性
    public void test2() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao user = (UserDao) app.getBean("userDao");
        app.close();
    }

    @Test
    //测试工厂方法实例化
    public void test3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao user1 = (UserDao) app.getBean("userDao");
        System.out.println(user1);
    }
}
