package com.sm.cn;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sm.cn.entity.BaseGood;
import com.sm.cn.service.IBaseGoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mapper.xml","classpath:applicationContext-service.xml"})
public class DemoTest {
    @Autowired
    private IBaseGoodService iBaseGoodService;

    @Test
    public void doTest(){
        List<BaseGood> all = iBaseGoodService.findAll();
        IPage<BaseGood> page = new Page<>(1,3);
        IPage<BaseGood> page1 = iBaseGoodService.findPage(page);
        System.out.println(all);
        System.out.println(page==page1);
    }
}
