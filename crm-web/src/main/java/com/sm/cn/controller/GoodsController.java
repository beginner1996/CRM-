package com.sm.cn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.cn.common.http.entity.ResponseBean;
import com.sm.cn.entity.Goods;
import com.sm.cn.entity.GoodsBrand;
import com.sm.cn.entity.GoodsType;
import com.sm.cn.entity.SearchBean;
import com.sm.cn.service.GoodsBrandService;
import com.sm.cn.service.GoodsService;
import com.sm.cn.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("findAll")
    public ResponseBean findAll(int currentPage, int pageSize,SearchBean searchBean){
        System.out.println("========================================================================"+searchBean);
        if ("".equals(searchBean.getGoodsBrandId())){
            searchBean.setGoodsBrandId(0);
        }
        if ("".equals(searchBean.getGoodsTypeId())){
            searchBean.setGoodsTypeId(0);
        }
        PageHelper.startPage(currentPage,pageSize);
        List<Goods> all = goodsService.searchPage(searchBean);
        PageInfo<Goods> pageInfo = new PageInfo<>(all);
        long total = pageInfo.getTotal();
        all.forEach(item->{
            Integer goodsBrandId = item.getGoodsBrandId();
            Integer goodsTypeId = item.getGoodsTypeId();
            String brandName = goodsBrandService.findById(goodsBrandId).getBrandName();
            String typeName = goodsTypeService.findById(goodsTypeId).getTypeName();
            item.setBrandName(brandName);
            item.setGoodsTypeName(typeName);
        });
        return ResponseBean.success(all,total);
    }

    @GetMapping("findBySearch")
    public ResponseBean findBySearch(SearchBean searchBean, int currentPage,int pageSize){
        System.out.println("========================================================================"+searchBean);
        PageHelper.startPage(currentPage,pageSize);
        List<Goods> all = goodsService.searchPage(searchBean);
        PageInfo<Goods> pageInfo = new PageInfo<>(all);
        long total = pageInfo.getTotal();
        all.forEach(item->{
            Integer goodsBrandId = item.getGoodsBrandId();
            Integer goodsTypeId = item.getGoodsTypeId();
            String brandName = goodsBrandService.findById(goodsBrandId).getBrandName();
            String typeName = goodsTypeService.findById(goodsTypeId).getTypeName();
            item.setBrandName(brandName);
            item.setGoodsTypeName(typeName);
        });
        return ResponseBean.success(all,total);
    }
    @PostMapping
    public ResponseBean addGoods(@RequestBody Goods goods){
        int row = goodsService.addGoods(goods);
        if (row > 0){
            return ResponseBean.success();
        }else {
            return ResponseBean.error();
        }
    }
    @PutMapping
    public ResponseBean updateGoods(@RequestBody Goods goods){
        int row = goodsService.updataGoods(goods);
        if (row > 0){
            return ResponseBean.success();
        }else {
            return ResponseBean.error();
        }
    }
    @GetMapping("{goodsId}")
    public ResponseBean findById(@PathVariable int goodsId){
        Goods byId = goodsService.findById(goodsId);
        Integer goodsBrandId = byId.getGoodsBrandId();
        String brandName = goodsBrandService.findById(goodsBrandId).getBrandName();
        byId.setBrandName(brandName);
        System.out.println("===============================================" + byId);
        return ResponseBean.success(byId);
    }
    @DeleteMapping("{goodsId}")
    public ResponseBean deleteGoods(@PathVariable int goodsId){
        int row = goodsService.deleteGoods(goodsId);
        if (row > 0){
            return ResponseBean.success();
        }else {
            return ResponseBean.error();
        }
    }

}
