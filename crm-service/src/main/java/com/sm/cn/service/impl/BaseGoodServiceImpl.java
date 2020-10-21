package com.sm.cn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.cn.entity.BaseGood;
import com.sm.cn.mapper.BaseGoodMapper;
import com.sm.cn.service.IBaseGoodService;
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
public class BaseGoodServiceImpl implements IBaseGoodService {
    @Autowired
    private BaseGoodMapper baseGoodMapper;

    @Override
    public List<BaseGood> findAll() {
        return baseGoodMapper.selectList(null);
    }

    @Override
    public IPage<BaseGood> findPage(IPage<BaseGood> page) {
        IPage<BaseGood> iPage = baseGoodMapper.selectPage(page, null);
        return iPage;
    }

    @Override
    public BaseGood findById(Serializable id) {
        return baseGoodMapper.selectById(id);
    }

    @Override
    public void addBaseGood(BaseGood baseGood) {
        baseGoodMapper.insert(baseGood);

    }
    @Override
    public void update(BaseGood baseGood) {
        baseGoodMapper.updateById(baseGood);

    }

    @Override
    public void deleteById(Serializable id) {
        baseGoodMapper.deleteById(id);

    }
}
