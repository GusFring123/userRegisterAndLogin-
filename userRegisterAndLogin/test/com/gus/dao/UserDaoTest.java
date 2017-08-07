package com.gus.dao;

import com.gus.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserDaoTest {

    private User user;
    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;
    InputStream inputStream = null;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUsername("asd1");
        user.setPassword("asd");
        user.setNickname("asd");
        user.setEmail("asd@qq.com");
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void addUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        userDao = sqlSession.getMapper(UserDao.class);
        userDao.addUser(user);
        sqlSession.commit();
    }

    @Test
    public void findUserByUsername() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        userDao = sqlSession.getMapper(UserDao.class);
        userDao.findUserByUsername("asd");
        sqlSession.commit();
        System.out.println(user);
    }

    @Test
    public void findUserByUNAndPSW() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        userDao = sqlSession.getMapper(UserDao.class);
        userDao.findUserByUNAndPSW("asd","asd");
        sqlSession.commit();
        System.out.println(user);
    }

}