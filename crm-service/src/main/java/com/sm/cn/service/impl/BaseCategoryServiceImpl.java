package com.sm.cn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sm.cn.entity.BaseCategory;
import com.sm.cn.mapper.BaseCategoryMapper;
import com.sm.cn.service.IBaseCategoryService;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-18
 */
@Service
@Transactional
@Log4j
public class BaseCategoryServiceImpl  implements IBaseCategoryService {



    @Autowired
    private BaseCategoryMapper baseCategoryMapper;
    @Override
    public List<BaseCategory> findAll() {
        IPage<BaseCategory> page= new Page<>(1,1);
        IPage<BaseCategory> page1 = baseCategoryMapper.selectPage(page, null);
        long total = page1.getTotal();
        log.info(total);
        List<BaseCategory> records = page1.getRecords();

        log.error("参数错误");
        return records;
    }

    @Override
    public BaseCategory findById(Serializable id) {
        return baseCategoryMapper.selectById(id);
    }
}
