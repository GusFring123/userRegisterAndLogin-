package com.gus.dao;

import com.gus.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public void addUser(User user);
    public User findUserByUsername(String username);
    public User findUserByUNAndPSW(@Param(value = "username") String username, @Param(value = "password") String password);
}
