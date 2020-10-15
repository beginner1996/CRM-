package com.sm.cn.service;

import com.sm.cn.entity.GoodsBrand;

import java.util.List;

public interface GoodsBrandService {
    /**
     * 查询所有的品牌
     * @return
     */
    List<GoodsBrand> findAll();

    /**
     * 根据ID查询品牌信息
     * @return
     */
    GoodsBrand findById(int id);

    /**
     *  根据typeID查询商品品牌
     * @param id
     * @return
     */
    List<GoodsBrand> findByTypeId(int id);

}
