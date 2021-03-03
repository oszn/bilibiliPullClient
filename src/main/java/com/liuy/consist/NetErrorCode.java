package com.liuy.consist;

public enum NetErrorCode {
    FETCH_ERR("-404"),
    unknown("111")
    ;
    String errorType;
    NetErrorCode(String i){
        errorType=i;
    }
}
