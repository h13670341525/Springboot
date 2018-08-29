package com.dhu.dao;

import com.dhu.App;
import com.dhu.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTest {

       @Autowired
       private UserDao userDao;
       @Test
       public void insertUsers(){
              for(int i=0;i<10000;i++){
                   User user=new User();
                   user.setUser_name("cherish"+(i+1));
                   user.setUser_count("cherish"+(i+1));
                   user.setUser_psw("123456");
                   userDao.insertUser(user);
              }
       }
       @Test
       public void FindUserById(){
              System.out.println(userDao.getUserById(1).getUser_name());
       }
}