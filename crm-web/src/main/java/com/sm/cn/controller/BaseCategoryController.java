package com.sm.cn.controller;


import com.sm.cn.entity.BaseCategory;
import com.sm.cn.service.IBaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-18
 */
@RestController
@RequestMapping("category")
public class BaseCategoryController {
    @Autowired
    private IBaseCategoryService iBaseCategoryService;

    @GetMapping("findAll")
    public List<BaseCategory> findAll(){
        return iBaseCategoryService.findAll();
    }
    @GetMapping("{id}")
    public BaseCategory findById(@PathVariable Serializable id){
        return iBaseCategoryService.findById(id);

    }

}
