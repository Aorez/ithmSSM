package com.aorez.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//Spring已经提供了该监听器
//@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ContextLoaderListener contextInitialized start");

//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ServletContext servletContext = servletContextEvent.getServletContext();
//        servletContext.setAttribute("app", app);

        ServletContext servletContext = servletContextEvent.getServletContext();
        String applicationContextLocation = servletContext.getInitParameter("applicationContextLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(applicationContextLocation);
        servletContext.setAttribute("app", app);

        System.out.println("ContextLoaderListener contextInitialized end");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ContextLoaderListener contextDestroyed start");
        System.out.println("ContextLoaderListener contextDestroyed end");
    }
}
