package com.liuy.consist;

public enum ErrorEnum {
    FETCH_ERR(1),
    MUL_ERR(2),
    ;
    private int type;
    ErrorEnum(int type){
        this.type=type;
    }
    public int type(){
        return type;
    }
}
