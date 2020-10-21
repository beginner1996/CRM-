package com.sm.cn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.cn.entity.BaseGood;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-18
 */
public interface IBaseGoodService {

    /**
     * 查询所有
     * @return
     */
    List<BaseGood> findAll();

    /**
     * 分页查询
     * @param page 分页对象
     * @return
     */
    IPage<BaseGood> findPage(IPage<BaseGood> page);

    /**
     * 根据id查询
     * @param id 主键
     * @return
     */
    BaseGood findById(Serializable id);

    /**
     * 添加商品
     * @param baseGood 商品实体类
     */
    void addBaseGood(BaseGood baseGood);

    /**
     * 修改商品信息
     * @param baseGood 商品实体类
     */
    void update(BaseGood baseGood);

    /**
     * 根据id删除商品
     * @param id 主键
     */
    void deleteById(Serializable id);
}
