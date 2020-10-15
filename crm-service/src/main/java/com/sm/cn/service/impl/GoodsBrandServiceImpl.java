package com.sm.cn.service.impl;

import com.sm.cn.entity.GoodsBrand;
import com.sm.cn.entity.GoodsBrandExample;
import com.sm.cn.mapper.GoodsBrandMapper;
import com.sm.cn.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GoodsBrandServiceImpl implements GoodsBrandService {
    @Autowired
    private GoodsBrandMapper goodsBrandMapper;
    @Override
    public List<GoodsBrand> findAll() {
        return goodsBrandMapper.selectByExample(null);
    }

    @Override
    public GoodsBrand findById(int id) {
        return goodsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GoodsBrand> findByTypeId(int id) {
        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        GoodsBrandExample.Criteria criteria = goodsBrandExample.createCriteria();
        criteria.andGoodsTypeIdEqualTo(id);
        return goodsBrandMapper.selectByExample(goodsBrandExample);
    }
}
