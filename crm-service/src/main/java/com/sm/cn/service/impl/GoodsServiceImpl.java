package com.sm.cn.service.impl;

import com.sm.cn.entity.Goods;
import com.sm.cn.entity.GoodsExample;
import com.sm.cn.entity.SearchBean;
import com.sm.cn.mapper.GoodsMapper;
import com.sm.cn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public List<Goods> findAll() {
        List<Goods> goods = goodsMapper.selectByExample(null);
        return goods;
    }

    @Override
    public Goods findById(int id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int updataGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }


    @Override
    public int deleteGoods(int id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Goods> searchPage(SearchBean searchBean) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (searchBean.getGoodsBrandId() > 0){
            criteria.andGoodsBrandIdEqualTo(searchBean.getGoodsBrandId());
        }
        if (searchBean.getGoodsTypeId() > 0){
            criteria.andGoodsTypeIdEqualTo(searchBean.getGoodsTypeId());
        }
        if (!StringUtils.isEmpty(searchBean.getText())){
            criteria.andGoodsNameLike("%"+searchBean.getText()+"%");
        }


        GoodsExample.Criteria criteria1 = goodsExample.createCriteria();
        if (searchBean.getGoodsTypeId() > 0){
            criteria1.andGoodsTypeIdEqualTo(searchBean.getGoodsTypeId());
        }
        if (searchBean.getGoodsBrandId() > 0){
            criteria1.andGoodsBrandIdEqualTo(searchBean.getGoodsBrandId());
        }
        if (!StringUtils.isEmpty(searchBean.getText())){
            criteria1.andGoodsModelLike("%"+searchBean.getText()+"%");
        }


        GoodsExample.Criteria criteria2 = goodsExample.createCriteria();
        if (searchBean.getGoodsTypeId() > 0 ){
            criteria2.andGoodsTypeIdEqualTo(searchBean.getGoodsTypeId());
        }
        if (searchBean.getGoodsBrandId() > 0){
            criteria2.andGoodsBrandIdEqualTo(searchBean.getGoodsBrandId());
        }
        if (!StringUtils.isEmpty(searchBean.getText())){
            criteria2.andGoodsColorLike("%"+searchBean.getText()+"%");
        }

        goodsExample.or(criteria);
        goodsExample.or(criteria1);
        goodsExample.or(criteria2);

        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        System.out.println("-------------------------------------------------------------------" + goods);
        return goods;
    }
}
