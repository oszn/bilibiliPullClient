package com.liuy.componet.task;

import com.liuy.componet.cache.RedisCache;
import com.liuy.service.PullBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
//@EnableScheduling
//@Component
public class torchGetTask {
    @Autowired
    RedisCache cache;
    @Autowired
    PullBuilder w;


    public Logger log= LoggerFactory.getLogger(this.getClass());
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
    public torchGetTask(){
        try {
            ip=InetAddress.getLocalHost();
        } catch ( UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(fixedDelay = 100)
    public void insert(){
        w.torchFetch();
    }
}
