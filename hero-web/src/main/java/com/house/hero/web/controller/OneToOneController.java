package com.house.hero.web.controller;

import com.house.hero.common.bean.MyOrder;
import com.house.hero.service.OneToOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/1/28
 * @ Description：一对一demo
 * @ throws
 */
@RestController
public class OneToOneController {

    @Autowired
    private OneToOneService oneToOneService;

    @RequestMapping("/oneToOne")
    public MyOrder queryOrderAndUserByOrderId (Integer id){

        return oneToOneService.queryOrderAndUserByOrderId(id);
    }
}
