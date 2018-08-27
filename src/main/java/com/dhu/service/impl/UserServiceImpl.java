package com.dhu.service.impl;

import com.dhu.annotation.RedisCache;
import com.dhu.dao.UserDao;
import com.dhu.domain.User;
import com.dhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @RedisCache
    @Override
    public User login(int user_id, String user_name) {
        return userDao.getUserByLogin(user_id,user_name);
    }
    @RedisCache
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
