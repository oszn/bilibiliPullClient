package com.liuy.consist;

public enum HttpType {
    NORMAL_FETCH(101),
    PROXY_FETCH(102),
    NORMAL_INDEX(201),PROXY_INDEX(202)
    ;
    int value;
    HttpType(int val){
        value=val;
    }
    public int value(){return value;};
}
