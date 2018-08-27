package com.dhu.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisHelper {

    @Autowired
    private RedisTemplate redisTemplate;

    public void saveCache(Object key,Object value){
      redisTemplate.opsForValue().set(key,value);
    }

    public void delCache(Object key){
        redisTemplate.delete(key);
    }

    public Object getCache(Object key){
       return redisTemplate.opsForValue().get(key);
    }

    public String genergateKey(String className,String methodName,Object[] args){
        StringBuffer sb=new StringBuffer();
        sb.append(className);
        sb.append("_");
        sb.append(methodName);
        for(Object arg:args){
            sb.append("_");
            sb.append(arg);
        }
        return sb.toString();
    }
}
