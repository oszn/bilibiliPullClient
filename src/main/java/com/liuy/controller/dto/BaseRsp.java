package com.liuy.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude
public class BaseRsp implements Serializable {

	private static final long serialVersionUID = -4185151304730685014L;

	private int status;
    private String message;
    private Object data;

    public BaseRsp(){}
    public BaseRsp(int status, String message) {
        this(status, message, null);
    }

    public BaseRsp(int status, Object data) {
        this(status, "", data);
    }

    public BaseRsp(Object data) {
        this(ResultEnum.SUCCESS.getState(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public BaseRsp(ResultEnum resultEnum) {
        this(resultEnum.getState(), resultEnum.getMsg(), null);
    }

    public BaseRsp(ResultEnum resultEnum, Object data) {
        this(resultEnum.getState(), resultEnum.getMsg(), data);
    }

    public BaseRsp(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
	public String toString() {
		return "BaseRsp [status=" + status + ", data=" + data + ", message=" + message + "]";
	}

}
