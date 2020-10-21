package com.sm.cn.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sm.cn.common.http.entity.AxiosResult;
import com.sm.cn.entity.BaseGood;
import com.sm.cn.entity.PageResult;
import com.sm.cn.service.IBaseGoodService;
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
@RequestMapping("good")
public class BaseGoodController {
    @Autowired
    private IBaseGoodService iBaseGoodService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public AxiosResult findAll(){
        return  AxiosResult.success(iBaseGoodService.findAll());
    }

    /**
     * 分页查询
     * @param currentPage 当前页数
     * @param pageSize 每一个的查询数量
     * @return
     */
    @GetMapping("pageList")
    public AxiosResult pageList(@RequestParam(defaultValue = "1") int currentPage,@RequestParam(defaultValue = "5") int pageSize){
        IPage<BaseGood> page= new Page<>(currentPage,pageSize);
        IPage<BaseGood> page1 = iBaseGoodService.findPage(page);
        return AxiosResult.success(PageResult.instance( page1.getRecords(),page1.getTotal()));
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AxiosResult findById(@PathVariable Serializable id){
        BaseGood byId = iBaseGoodService.findById(id);
        return AxiosResult.success(byId);
    }

    /**
     * 新增
     * @param baseGood post请求中的数据
     * @return
     */
    @PostMapping
    public AxiosResult addBaseGood(@RequestBody BaseGood baseGood){
        iBaseGoodService.addBaseGood(baseGood);
        return  AxiosResult.success();
    }

    /**
     * 修改
     * @param baseGood 修改后的实体类
     * @return
     */
    @PutMapping
    public AxiosResult edit(@RequestBody BaseGood baseGood){
        iBaseGoodService.update(baseGood);
        return AxiosResult.success();
    }

    /**
     * 通过id删除
     * @param id 需要删除的实体类的id
     * @return
     */
    @DeleteMapping("{id}")
    public AxiosResult delete(@PathVariable Serializable id){
        iBaseGoodService.deleteById(id);
        return  AxiosResult.success();
    }






}
