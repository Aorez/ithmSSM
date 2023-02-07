package com.aorez.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    //测试c3p0
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        //用mysql自带数据库mysql进行测试
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root221899");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试druid
    public void test2() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //用MySQL自带数据库mysql进行测试
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/mysql");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root221899");
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试properties配置文件
    public void test3() throws PropertyVetoException, SQLException {
        //不用加后缀名
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("jdbc.driver");
        String url = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("jdbc.username");
        String password = resourceBundle.getString("jdbc.password");
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //Spring xml配置文件配置数据源
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) app.getBean("comboPooledDataSource");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();

        DruidDataSource druidDataSource = (DruidDataSource) app.getBean("druidDataSource");
        DruidPooledConnection connection1 = druidDataSource.getConnection();
        System.out.println(connection1);
        connection1.close();
    }
}
