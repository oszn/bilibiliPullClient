//package com.myLogger.component.myquarz;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.util.Date;
//
//import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
//import static org.quartz.TriggerBuilder.newTrigger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//public class trigger {
//    public static Logger logger=LoggerFactory.getLogger (trigger.class);
//    public static void main( String[] args ) {
//        SchedulerFactory factory=new StdSchedulerFactory ();
//        try {
//            //任务调度
//            Scheduler scheduler=factory.getScheduler();
//            //job
//            JobDetail jobDetail= JobBuilder.newJob(slowGet.class).withDescription("hello world").withIdentity("group1","liu").build();
////            JobDetail SimplerjobDetail= JobBuilder.newJob(simplerJob.class).withDescription("hello world").withIdentity("group2","liu").build();
//            //触发器
//            Trigger trigger= newTrigger().
//                    withIdentity("group1","mytirgger").
//                    withDescription("hello trigger").
//                    startAt(new Date(System.currentTimeMillis())).
//                    withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).
//                    build();
//            //绑定
//            logger.info ("start");
////            scheduler.scheduleJob(SimplerjobDetail,simpleTrigger);
//            scheduler.scheduleJob(jobDetail,trigger);
////            scheduler.scheduleJob(s)
//            scheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
