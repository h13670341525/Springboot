package com.dhu.service;

import com.dhu.annotation.RedisCache;
import com.dhu.domain.User;

import java.util.List;

public interface UserService {
    public User login(String user_count,String user_psw);
    public List<User> getUsers();
}
