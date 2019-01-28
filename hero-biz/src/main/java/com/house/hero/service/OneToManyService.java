package com.house.hero.service;

import com.house.hero.common.bean.MyOrder;
import com.house.hero.mapper.MyOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/1/28
 * @ Description：一对多 根据订单主键id查询所属用户及订单包含的详情信息
 * @ throws
 */
@Service
public class OneToManyService {

    @Autowired
    private MyOrderMapper myOrderMapper;

    /**
     * @ Author jmy
     * @ Description //TODO User
     * @ Date 2019/1/28
     * @ Param [id] 订单主键id
     * @ return com.house.hero.common.bean.MyOrder
     **/
    public MyOrder queryOrderAndUserAndOrderDetailsByOrderId(Integer id){

        return myOrderMapper.queryOrderAndUserAndOrderDetailsByOrderId(id);
    }
}
