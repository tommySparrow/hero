package com.house.hero.mapper;

import com.github.abel533.mapper.Mapper;
import com.house.hero.common.bean.Record;

import java.util.List;

public interface RecordMapper extends Mapper<Record> {
    List<Record> selectRecords();
}