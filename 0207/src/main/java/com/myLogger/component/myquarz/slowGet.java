package com.myLogger.component.myquarz;


import com.myLogger.component.HbaseConfig.HBaseLog;
import com.myLogger.component.cache.RedisCache;
import com.myLogger.http.walkMilk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//import java.util.logging.Logger;
@Component
@EnableScheduling
public class slowGet  {
    @Autowired
    RedisCache cache;
    @Autowired
    walkMilk w;
    @Autowired
    HBaseLog hBaseLog;
    private final Logger logger= LoggerFactory.getLogger (this.getClass ());
    private static long a=2;

    public slowGet(){
//        w=new walkMilk ();
//        cache.init();
    }
    @Scheduled(fixedDelay = 5000)
    public void insert(){
        //logger.info("触发呀！");
        while (cache.get(String.valueOf(a))!=null)
        {
            a++;
            logger.info("第{}用户已注册",a);
            hBaseLog.insert_log ("第"+String.valueOf (a)+"用户已注册",new Date ().toString (),String.valueOf (a),String.valueOf (1));

        }
        cache.set(String.valueOf(a),"1");
        logger.info ("第{}个用户开始",a);
        hBaseLog.insert_log ("第"+String.valueOf (a)+"用户开始",new Date ().toString (),String.valueOf (a),String.valueOf (0));

        w.insert (String.valueOf (a));
        a++;
    }
//    @Override
//    public void execute( JobExecutionContext jobExecutionContext ) throws JobExecutionException {
//        while (cache.get(String.valueOf(a))!=null)
//        {
//            a++;
//        }
//        logger.info ("第{}个用户开始",a);
//        w.insert (String.valueOf (a));
//        a++;
//    }
}
