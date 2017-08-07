package com.gus.service;

import com.gus.domain.User;
import com.gus.exception.MsgException;

/**
 * The interface User service.
 */
public  interface UserService {
    /**
     * Register user.
     *
     * @param user the user
     * @throws MsgException the msg exception
     */
    public void registerUser(User user) throws MsgException;

    /**
     * Isuser user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    public User isuser(String username, String password);
}
