package com.liuy.controller.dto;

/**
 * @Auther: bke
 * @Date: 2018/9/6 16:15
 * @Description:
 */
public class ErrRsp {
    private ErrEntity error;
    public ErrRsp(){}
    public ErrRsp(int status, String desc, Object data){
        this.error = new ErrEntity(status, desc, data);
    }

    public ErrRsp(int status, String desc){
        this.error = new ErrEntity(status, desc);
    }

    public ErrEntity getError() {
        return error;
    }

    public void setError(String status, String desc) {
        this.error = error;
    }
}
