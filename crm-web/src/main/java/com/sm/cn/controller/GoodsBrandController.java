package com.sm.cn.controller;

import com.sm.cn.common.http.entity.ResponseBean;
import com.sm.cn.entity.GoodsBrand;
import com.sm.cn.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goodsBrand")
public class GoodsBrandController {
    @Autowired
    private GoodsBrandService goodsBrandService;
    @GetMapping("findAll")
    public ResponseEntity findAll(){
        List<GoodsBrand> all = goodsBrandService.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("findByTypeId")
    public ResponseBean findByTypeId( int  goodsTypeId){
        List<GoodsBrand> byTypeId = goodsBrandService.findByTypeId(goodsTypeId);
        return ResponseBean.success(byTypeId);
    }
}
