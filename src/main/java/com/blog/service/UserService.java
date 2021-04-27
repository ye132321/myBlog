package com.blog.service;

import com.blog.beans.User;

public interface UserService {
    User checkUser(String username,String password);
}
