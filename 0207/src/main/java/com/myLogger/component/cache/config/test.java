package com.myLogger.component.cache.config;

import redis.clients.jedis.Jedis;

public class test {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("http://localhost:6379");
        jedis.auth("douqu");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        System.out.println("======================key==========================");
        //清除当前数据库所有数据
        jedis.flushDB();
        //设置键值对
        jedis.set("xiaohua","我是小花");
        //查看存储的键的总数
        System.out.println(jedis.dbSize());
        //取出设置的键值对并打印
        System.out.println(jedis.get("xiaohua"));

//        RedisCache redisCache=new RedisCache();
//        redisCache.putCache("hello","xxx");


    }
}
