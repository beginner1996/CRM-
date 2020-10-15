package com.sm.cn.service;

import com.sm.cn.entity.Goods;
import com.sm.cn.entity.SearchBean;

import java.util.List;

public interface GoodsService {
    /**
     * 查询所有的商品
     * @return
     */
    List<Goods> findAll();

    /**
     *根据id查询商品
     * @param id
     * @return
     */
    Goods findById(int id);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 修改商品信息
     * @param goods
     * @return
     */
    int updataGoods(Goods goods);


    /**
     * 通过id删除商品
     * @param id
     * @return
     */
    int deleteGoods(int id);

    /**
     * 条件查询
     * @param searchBean
     * @return
     */
    List<Goods> searchPage(SearchBean searchBean);
}
