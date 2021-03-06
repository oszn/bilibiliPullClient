package com.liuy.controller.dto;

/**
 * @Auther: bke
 * @Date: 2018/9/6 16:16
 * @Description:
 */
public class ErrEntity {
    private int status;
    private String description;
    private Object data;

    public ErrEntity(){}
    public ErrEntity(int status, String description, Object data){
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public ErrEntity(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
