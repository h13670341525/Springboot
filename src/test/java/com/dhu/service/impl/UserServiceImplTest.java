package com.dhu.service.impl;

import com.dhu.cache.RedisHelper;
import com.dhu.domain.User;
import com.dhu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
      @Autowired
      private UserService userService;
      @Autowired
      private RedisHelper redisHelper;

      @Test
      public void testCache(){
            System.out.println(userService.login(1,"cherish").getUser_name());
      }

      @Test
      public void testUsers(){
            System.out.println(userService.getUsers());
      }
      @Test
      public void testRedis(){
            List<User> users= (List<User>) redisHelper.getCache("com.dhu.service.impl.UserServiceImpl_getUsers");
            for(User user:users){
                  System.out.println(user.getUser_id()+" "+user.getUser_name());
            }
      }
}