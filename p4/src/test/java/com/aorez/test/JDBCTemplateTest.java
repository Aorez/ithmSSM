package com.aorez.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JDBCTemplateTest {
    @Test
    //测试JDBCTemplate
    //数据库设置为spring，表account，字段name varchar 主键，money double
    public void test1() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUser("root");
        dataSource.setPassword("root221899");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("insert into account values (?, ?)", "Tom", 5000);

        System.out.println("test1 update 行数" + row);
    }
}
