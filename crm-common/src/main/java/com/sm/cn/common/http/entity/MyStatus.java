package com.sm.cn.common.http.entity;

public enum MyStatus {
    OK(20000,"操作成功"),
    ERROR(50000,"操作失败")
    ;
    private int status;
    private String msg;

    MyStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
