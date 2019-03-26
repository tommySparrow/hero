package com.house.hero.service;

import com.house.hero.common.bean.Menu;
import com.house.hero.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/3/26
 * @ Description：
 * @ throws
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> selectMenuList() {
        return  menuMapper.select(new Menu());
    }
}
