package com.sm.cn.controller;

import com.sm.cn.common.http.entity.ResponseBean;
import com.sm.cn.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @GetMapping("findAll")
    public ResponseBean findAll(){
        return ResponseBean.success(goodsTypeService.findAll());
    }
    @GetMapping("findById")
    public ResponseEntity findById(int id){
        return ResponseEntity.ok(goodsTypeService.findById(id));
    }
}
