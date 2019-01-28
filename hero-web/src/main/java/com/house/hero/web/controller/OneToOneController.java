package com.house.hero.web.controller;

import com.house.hero.common.bean.MyOrder;
import com.house.hero.service.OneToOneService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ApiOperation(value="获取订单及用户信息", notes="根据主键id来获取订单及用户信息")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, paramType = "query",dataType = "Integer")
    @RequestMapping(value = "/oneToOne",method = RequestMethod.GET)
    public MyOrder queryOrderAndUserByOrderId (Integer id){

        return oneToOneService.queryOrderAndUserByOrderId(id);
    }
}
