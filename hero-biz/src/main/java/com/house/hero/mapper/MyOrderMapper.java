package com.house.hero.mapper;

import com.house.hero.common.bean.MyOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyOrderMapper extends com.github.abel533.mapper.Mapper<MyOrder> {

    MyOrder queryOrderAndUserByOrderId(Integer id);

    MyOrder queryOrderAndUserAndOrderDetailsByOrderId(Integer id);
}