package com.dhu.config;

import com.dhu.task.FirstJob;
import com.dhu.task.SecondJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfiguration {
    @Bean(name = "firstJobDetail")
    public MethodInvokingJobDetailFactoryBean FirstJobDetail(FirstJob firstJob){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setTargetObject(firstJob);
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }
    @Bean(name="secondJobDetail")
    public MethodInvokingJobDetailFactoryBean SecondJobDetail(SecondJob secondJob){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setTargetObject(secondJob);
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }
    @Bean(name="firstTrigger")
    public SimpleTriggerFactoryBean FirstTrigger(JobDetail firstJobDetail){
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(firstJobDetail);
        trigger.setRepeatInterval(10000);
        trigger.setRepeatCount(5);
        return  trigger;
    }
    @Bean(name="secondTrigger")
    public CronTriggerFactoryBean SecondTrigger(JobDetail secondJobDetail){
        CronTriggerFactoryBean trigger=new CronTriggerFactoryBean();
        trigger.setJobDetail(secondJobDetail);
        trigger.setCronExpression("0/15 * * * * ?");
        return trigger;
    }
    //@Bean
    public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger,Trigger secondTrigger){
        SchedulerFactoryBean schelduler = new SchedulerFactoryBean();
        schelduler.setStartupDelay(1);
        schelduler.setTriggers(firstTrigger,secondTrigger);
        return schelduler;
    }
}
