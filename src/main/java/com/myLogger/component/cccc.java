package com.myLogger.component;

import com.myLogger.component.cache.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//public class cccc {
//    private final Logger logger= LoggerFactory.getLogger (this.getClass ());
//    @Autowired
//    RedisCache cache;
//    @Scheduled(cron = "0/2 * * * * ?")
//    public void doTask() {
//        logger.info(Thread.currentThread().getName()+"===task run");
//    }
//}
