package com.aorez.web;

import com.aorez.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService) app.getBean("userService");
//        userService.save();

//        ServletContext servletContext1 = this.getServletContext();

//        ServletContext servletContext = req.getServletContext();
//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
//        UserService userService = (UserService) app.getBean("userService");
//        userService.save();

//        ServletContext servletContext = req.getServletContext();
//        ApplicationContext app = WebApplicationContextUtils.getApplicationContext(servletContext);
//        UserService userService = (UserService) app.getBean("userService");
//        userService.save();

        //Spring已经提供了WebApplicationContextUtils
        ServletContext servletContext = req.getServletContext();
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
