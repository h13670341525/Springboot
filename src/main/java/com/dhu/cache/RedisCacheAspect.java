package com.dhu.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RedisCacheAspect {

    @Autowired
    private RedisHelper redisHelper;

    @Pointcut("@annotation(com.dhu.annotation.RedisCache)")
    public  void setJoinPoint(){}

    @Around(value = "setJoinPoint()")
    public Object around(ProceedingJoinPoint jp){
        Object result=null;
        try {
            String className=jp.getSignature().getDeclaringTypeName();
            String methodName=jp.getSignature().getName();
            Object[] args=jp.getArgs();
            String key=redisHelper.genergateKey(className,methodName,args);
            result=redisHelper.getCache(key);
            if(result==null) {
                result=jp.proceed();
                redisHelper.saveCache(key,result);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
