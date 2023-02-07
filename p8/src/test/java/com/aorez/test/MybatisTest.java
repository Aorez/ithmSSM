package com.aorez.test;

import com.aorez.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //加载xml
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得sql session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

        //获得sql session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("UserMapper.findAll");

        System.out.println(userList);

        sqlSession.close();
    }
}
