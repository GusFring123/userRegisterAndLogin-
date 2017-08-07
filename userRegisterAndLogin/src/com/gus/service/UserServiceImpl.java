package com.gus.service;

import com.gus.dao.UserDao;
import com.gus.domain.User;
import com.gus.exception.MsgException;
import com.gus.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    private SqlSession sqlSession = DBUtils.getSqlSession(true);
    private UserDao userDao = sqlSession.getMapper(UserDao.class);

    @Override
    public void registerUser(User user) throws MsgException {
//        1.检查数据库是否含有用户名，如果重复，则提示，和数据库打交道的，所以这里的用户名校验要放在这里
        if (userDao.findUserByUsername(user.getUsername()) != null) {
            throw new MsgException("用户名已经存在");
        }
//        2.如果不没有重复，则添加用户
        userDao.addUser(user);
    }

    @Override
    public User isuser(String username, String password) {
//        1.检查和数据库中是否有用户名与密码复合条件的user，如果有，则返回。
        return userDao.findUserByUNAndPSW(username, password);
    }
}
