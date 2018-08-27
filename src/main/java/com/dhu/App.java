package com.dhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations={"classpath:spring-redis.xml"})
@SpringBootApplication
@ServletComponentScan
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
