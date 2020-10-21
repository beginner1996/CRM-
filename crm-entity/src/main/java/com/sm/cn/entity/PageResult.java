package com.sm.cn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageResult {
    private Object records;
    private Long total;
    public static PageResult instance(Object records,Long total){
        return new PageResult(records,total);
    }
}
