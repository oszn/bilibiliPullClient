package com.myLogger.tools;

public class test2 {
    public static void main(String[] args) {
        Thread x=new Thread();
        for(int i=0;i<100;i++){
            test tmp=new test();
            System.out.println(i);
            tmp.run();
        }
    }
}
