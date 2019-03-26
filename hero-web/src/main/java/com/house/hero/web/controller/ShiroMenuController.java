package com.house.hero.web.controller;

import com.house.hero.common.bean.Menu;
import com.house.hero.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/3/26
 * @ Description：
 * @ throws
 */
@RestController
@RequestMapping("/menu")
public class ShiroMenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/select")
    @RequiresPermissions("menu:list")
    public List<Menu> selectMenuList(){
        return menuService.selectMenuList();
    }
}
