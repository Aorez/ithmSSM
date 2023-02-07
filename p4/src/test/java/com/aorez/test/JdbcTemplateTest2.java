package com.aorez.test;

import com.aorez.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class JdbcTemplateTest2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    //受到弹幕的启发，利用之前的SpringJunit进行测试
    //在xml中配置数据源和jdbctemplate，并测试，进行update插入新数据
    public void test2() {
        String sql = "insert into account values(?,?)";
        int row = jdbcTemplate.update(sql, "test2", 2);
        System.out.println(row);
    }

    @Test
    //测试查询语句
    public void test3() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accountList);

        Account account = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), "test2");
        System.out.println(account);

        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
}
