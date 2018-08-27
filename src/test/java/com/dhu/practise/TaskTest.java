package com.dhu.practise;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TaskTest{

    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();
        Scheduler scheduler= null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
