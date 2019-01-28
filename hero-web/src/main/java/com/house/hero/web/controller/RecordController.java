package com.house.hero.web.controller;

import com.house.hero.common.bean.Record;
import com.house.hero.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/10/24
 * @ Description：
 * @ throws
 */
@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     * @ Author jmy
     * @ Description //TODO User
     * @ Date 2018/10/29
     * @ Param []
     * @ return java.util.List<com.hero.hero.common.bean.Record>
     **/
    @RequestMapping(value = "/getRecords",method = RequestMethod.GET)
    public List<Record> selectRecords(){

        List<Record> recordList = recordService.selectRecords();
        return recordList;
    }
}
