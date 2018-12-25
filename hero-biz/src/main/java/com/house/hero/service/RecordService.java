package com.house.hero.service;

import com.house.hero.common.bean.Record;
import com.house.hero.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/10/24
 * @ Description：
 * @ throws
 */

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public List<Record> selectRecords(){

        return  recordMapper.selectRecords();
    }
}
