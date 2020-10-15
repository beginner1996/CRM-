package com.sm.cn.service.impl;

import com.sm.cn.entity.GoodsType;
import com.sm.cn.mapper.GoodsTypeMapper;
import com.sm.cn.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> findAll() {
        return goodsTypeMapper.selectByExample(null);
    }

    @Override
    public GoodsType findById(int id) {
        return goodsTypeMapper.selectByPrimaryKey(id);
    }
}
