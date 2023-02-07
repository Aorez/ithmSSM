package com.aorez.test;

import com.aorez.domain.Order;
import com.aorez.domain.SysUser;
import com.aorez.domain.User;
import com.aorez.mapper.OrderMapper;
import com.aorez.mapper.SysUserMapper;
import com.aorez.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    //测试一对一，查询所有订单，每个订单对应一个用户
    public void test1() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = factory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.findAll();
        System.out.println(orderList);
        sqlSession.close();
    }

    @Test
    //测试一对多，查询所有用户，附带每个用户有多个订单
    public void test2() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    //测试多对多，查询所有sys user，每个user可以有多个角色
    public void test3() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = factory.openSession();
        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        List<SysUser> sysUserList = sysUserMapper.findAll();
        System.out.println(sysUserList);
        sqlSession.close();
    }
}
