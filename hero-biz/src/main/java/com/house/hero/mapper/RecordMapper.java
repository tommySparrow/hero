package com.house.hero.mapper;

import com.house.hero.common.bean.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper extends com.github.abel533.mapper.Mapper<Record> {
    List<Record> selectRecords();
}