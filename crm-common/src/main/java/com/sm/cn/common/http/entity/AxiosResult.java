package com.sm.cn.common.http.entity;

import java.util.HashMap;

public class AxiosResult extends HashMap<String,Object> {
    public static final String STATUS="status";
    public static final String MSG="msg";
    public static final String DATA="data";

    public AxiosResult(MyStatus myStatus){
        super.put(STATUS,myStatus.getStatus());
        super.put(MSG,myStatus.getMsg());
    }
    public static AxiosResult success(){
        return new AxiosResult(MyStatus.OK);
    }
    public static AxiosResult success(MyStatus myStatus){
        return new AxiosResult(myStatus);
    }
    public static AxiosResult success(Object obj){
        AxiosResult axiosResult = new AxiosResult(MyStatus.OK);
        axiosResult.put(DATA,obj);
        return axiosResult;
    }

    public static AxiosResult error(){
        return new  AxiosResult(MyStatus.ERROR);
    }
    public static AxiosResult error(MyStatus myStatus){
        return new AxiosResult(myStatus);
    }

}
