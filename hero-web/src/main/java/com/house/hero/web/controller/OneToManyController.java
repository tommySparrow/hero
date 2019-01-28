package com.house.hero.web.controller;

import com.house.hero.common.bean.MyOrder;
import com.house.hero.service.OneToManyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/1/28
 * @ Description：一对多demo
 * @ throws
 */
@RestController
public class OneToManyController {

    @Autowired
    private OneToManyService oneToManyService;

    @ApiOperation(value="获取订单及用户信息及订单中详情", notes="根据主键id来获取")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, paramType = "query",dataType = "Integer")
    @RequestMapping(value = "/oneToMany",method = RequestMethod.GET)
    public MyOrder queryOrderAndUserAndOrderDetailsByOrderId(Integer id){

        return oneToManyService.queryOrderAndUserAndOrderDetailsByOrderId(id);
    }
}
