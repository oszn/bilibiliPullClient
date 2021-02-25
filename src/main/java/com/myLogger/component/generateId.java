package com.myLogger.component;

public class generateId {
    public static long fromtime(int uid){
        long date=System.currentTimeMillis();
        date=date<<16;
        date+=uid;
        return date;
    }
}
