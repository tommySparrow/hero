package com.house.hero.mapper;

import com.github.abel533.mapper.Mapper;
import com.house.hero.common.bean.OrderDetail;

public interface OrderDetailMapper extends Mapper<OrderDetail> {

    OrderDetail selectOrderDetailsById(Integer id);
}