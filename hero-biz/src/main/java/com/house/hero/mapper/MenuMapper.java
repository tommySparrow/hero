package com.house.hero.mapper;

import com.github.abel533.mapper.Mapper;
import com.house.hero.common.bean.Menu;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {

    List<Menu> selectMenuList();
}