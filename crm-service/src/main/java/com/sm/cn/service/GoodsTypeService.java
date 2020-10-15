package com.sm.cn.service;

import com.sm.cn.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    /**
     * 查询所有的商品类型
     * @return
     */
    List<GoodsType> findAll();

    /**
     * 根据id查询商品类型
     * @return
     */
    GoodsType findById(int id);
}
