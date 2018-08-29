package com.dhu.service;

import com.dhu.annotation.RedisCache;
import com.dhu.domain.User;

import java.util.List;

public interface UserService {
    User login(String user_count,String user_psw);
    String register(String user_count,String user_psw);
    List<User> getUsers();
}
