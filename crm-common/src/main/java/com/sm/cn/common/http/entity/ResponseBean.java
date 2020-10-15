package com.sm.cn.common.http.entity;

import java.util.HashMap;

public class ResponseBean extends HashMap<String,Object> {

    public static final String STATUS = "status";
    public static final String MSG = "msg";
    public static final String DATA = "data";
    public static final String TOTAL = "total";

    public ResponseBean(){}

    public ResponseBean(MyStatus myStatus){
        super.put(STATUS,myStatus.getStatus());
        super.put(MSG,myStatus.getMsg());
    }

    public static ResponseBean success(){
        return new ResponseBean(MyStatus.OK);
    }
    public static ResponseBean success(MyStatus myStatus){
        return new ResponseBean(myStatus);
    }
    public static ResponseBean error(){
        return new ResponseBean(MyStatus.ERROR);
    }

    public static ResponseBean error(MyStatus myStatus){
        return new ResponseBean(myStatus);
    }
    public static ResponseBean success(Object data){
        ResponseBean success = success();
        success.put(DATA,data);
        return success;
    }
    public static ResponseBean success(Object data,long total){
        ResponseBean success = success(data);
        success.put(TOTAL,total);
        return success;
    }
}
