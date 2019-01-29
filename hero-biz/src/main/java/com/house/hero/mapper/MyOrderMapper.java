package com.house.hero.mapper;

import com.github.abel533.mapper.Mapper;
import com.house.hero.common.bean.MyOrder;

public interface MyOrderMapper extends Mapper<MyOrder> {

    MyOrder queryOrderAndUserByOrderId(Integer id);

    MyOrder queryOrderAndUserAndOrderDetailsByOrderId(Integer id);
}