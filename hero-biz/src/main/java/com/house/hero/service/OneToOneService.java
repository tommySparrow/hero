package com.house.hero.service;

import com.house.hero.common.bean.MyOrder;
import com.house.hero.mapper.MyOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/1/28
 * @ Description：一对一的demo
 * @ throws
 */
@Service
public class OneToOneService {

    @Autowired
    private MyOrderMapper orderMapper;
    /**
     * @ Author jmy
     * @ Description //TODO User
     * @ Date 2019/1/28
     * @ Param [id] order表的主键id
     * @ return com.house.hero.common.bean.MyOrder
     **/
    public MyOrder queryOrderAndUserByOrderId(Integer id){

        return orderMapper.queryOrderAndUserByOrderId(id);
    }
}
