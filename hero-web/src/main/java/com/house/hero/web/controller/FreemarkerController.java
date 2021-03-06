package com.house.hero.web.controller;

import com.house.hero.common.bean.Record;
import com.house.hero.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FreemarkerController {


    @Autowired
    private RecordService recordService;

    /**
     * @ Author jmy
     * @ Description //TODO User
     * @ Date 2018/10/29
     * @ Param [modelMap]
     * @ return java.lang.String
     **/
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String testRecords(ModelMap modelMap){

        List<Record> recordList = recordService.selectRecords();
        Record record = recordList.get(0);
        modelMap.addAttribute("record",record);
        return "hello";
    }

    /**
     * @ Author jmy
     * @ Description //TODO User
     * @ Date 2018/10/29
     * @ Param []
     * @ return java.lang.String
     **/
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        return "homepage/index";
    }
}
