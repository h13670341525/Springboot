package com.dhu.util;

import com.dhu.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    Jedis jedis=null;
    @Before
    public void before(){
//        jedis = new Jedis("localhost");
        System.out.println("连接成功");
    }
    @After
    public void after(){
//        jedis.close();
        System.out.println("关闭成功");
    }
    @Test
    public void setTest(){
        jedis.set("java","good");
    }
    @Test
    public void getTest(){
        System.out.println(jedis.get("hahah".getBytes()));
    }
    @Test
    public void delTest(){
        jedis.del("java");
    }
    @Test
    public void pushTest(){
        jedis.lpush("subject","english");
        jedis.lpush("subject","math");
        jedis.lpush("subject","chinese");
        List<String> list = jedis.lrange("subject",0,-1);
        for(String str:list){
            System.out.println(str);
        }
    }
    @Test
    public void objectTest(){
         User user=new User();
         user.setUser_id(2);
         user.setUser_name("cherish");
         user.setCreatetime(new Timestamp(new Date().getTime()));
         jedis.set("user_1".getBytes(),SerializeUtil.serialize(user));
         User temuser= (User) SerializeUtil.unserizlize(jedis.get("user_1".getBytes()));
        System.out.println(user.getUser_id()+" "+user.getUser_name()+" "+user.getCreatetime());
    }
    @Test
    public void objectListTest(){
        for(int i=0;i<5;i++){
            User user=new User();
            user.setUser_id(i+1);
            user.setUser_name("cherish"+(i+1));
            user.setCreatetime(new Timestamp(new Date().getTime()));
            jedis.rpush("users".getBytes(),SerializeUtil.serialize(user));
        }
        List<byte[]> tems=jedis.lrange("users".getBytes(),0,-1);
        List<User> users=new ArrayList<>();
        for(byte[] tem:tems){
            users.add((User) SerializeUtil.unserizlize(tem));
        }
        for(User user:users){
            System.out.println(user.getUser_id()+" "+user.getUser_name()+" "+user.getCreatetime());
        }
    }

}
