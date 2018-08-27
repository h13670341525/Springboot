package com.dhu.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class FirstJob {
    private int count=1;
    public void execute(){
        System.out.println("FirstJob执行"+count++);
    }
}
