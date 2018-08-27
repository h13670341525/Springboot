package com.dhu.service;

import com.dhu.annotation.RedisCache;
import com.dhu.domain.User;

import java.util.List;

public interface UserService {
    public User login(int user_id,String user_name);
    public List<User> getUsers();
}
