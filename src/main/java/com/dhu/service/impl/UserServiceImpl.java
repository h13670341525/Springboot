package com.dhu.service.impl;

import com.dhu.dao.UserDao;
import com.dhu.domain.User;
import com.dhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User login(String user_count, String user_psw) {
        return userDao.findUserByLogin(user_count,user_psw);
    }

    @Override
    public String register(String user_count, String user_psw) {
           /*
            *同步机制解决高并发，2000并发平均时间为18秒;
           */
            synchronized (this) {
                if (userDao.findUserByCount(user_count) == null) {
                    User user = new User();
                    user.setUser_name(user_count);
                    user.setUser_count(user_count);
                    user.setUser_psw(user_psw);
                    userDao.insertUser(user);
                    return "success";
                }
            }
            return "fail";
            /*
            数据异常解决高并发 2000并发平均时间4秒
            */
            /*
            User user = new User();
            user.setUser_name(user_count);
            user.setUser_count(user_count);
            user.setUser_psw(user_psw);
            try {
                userDao.insertUser(user);
            }catch (Exception e){
                return "fail";
            }
            return "success";
            */
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
