package com.blog.service.impl;

import com.blog.beans.User;
import com.blog.dao.UserDao;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User checkUser(String username, String password) {
       return userDao.findByUsernameAndPassword(username,password);
    }
}
