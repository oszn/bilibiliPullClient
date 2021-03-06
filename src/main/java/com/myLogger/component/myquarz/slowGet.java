package com.myLogger.component.myquarz;


import com.myLogger.component.cache.RedisCache;
import com.myLogger.http.walkMilk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

//import java.util.logging.Logger;
@Component
@EnableScheduling
public class slowGet  {
    @Autowired
    RedisCache cache;
    @Autowired
    walkMilk w;


    public Logger log=LoggerFactory.getLogger(this.getClass());
    public int getEpoch() {
        return epoch;
    }

    public void setEpoch(int epoch) {
        this.epoch = epoch;
    }
    public static String prefix="bili";
    @Value("${table.number}")
    private int epoch;
    private final Logger logger= LoggerFactory.getLogger (this.getClass ());
    private int limit=10;
    private int count=10;
    private int index=0;
    InetAddress ip;
    public slowGet(){
        try {
            ip=InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(fixedDelay = 3000)
    public void insert(){
        if(count>=limit){
            index=w.mul(limit);
            log.info("{}用户,address:{},pull from server index:{},limit:{}",ip.getHostName(),ip.getHostAddress(),index,limit);
            count=0;
        }

        String user=String.valueOf(index+count);
        count++;
//        String user=cache.get(prefix+String.valueOf(epoch));
        logger.info ("第{}个epoch第{}个用户开始",epoch,user);

        if(user!="null"&&user!=null){
            cache.set(prefix+String.valueOf(epoch), String.valueOf(Long.parseLong(user)+1));
        }

        String uid=w.insert (String.valueOf (user),prefix+String.valueOf(epoch));

        if(user=="null"||user==null)

        cache.set(prefix+String.valueOf(epoch), String.valueOf(Long.parseLong(uid)+1));
//        if(uid=="")

    }
}
