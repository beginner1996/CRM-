package com.sm.cn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.cn.entity.BaseCategory;

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
public interface IBaseCategoryService {
    /**
     * 查找所有
     * @return
     */
    List<BaseCategory> findAll();

    /**
     * 根据id查询
     * @param id 主键id
     * @return
     */
    BaseCategory findById(Serializable id);

}
