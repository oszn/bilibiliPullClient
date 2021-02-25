package com.myLogger.component.exception;

public class TypeException extends Exception {
    int type;
    String errorType;
    long mid;
    public TypeException(Exception e,long mid){

    }
}
