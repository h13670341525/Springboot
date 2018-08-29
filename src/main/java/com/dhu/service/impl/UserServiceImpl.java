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
    @Override
    public User login(String user_count, String user_psw) {
        return userDao.getUserByLogin(user_count,user_psw);
    }
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
