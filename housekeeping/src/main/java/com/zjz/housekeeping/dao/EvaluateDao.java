package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.Evaluate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluateDao {
    void add(Evaluate evaluate);

    void delete(Integer evaluateId);

    Evaluate queryById(Integer evaluateId);

    void update(Evaluate evaluate);

    List<Evaluate> queryCondition(Evaluate evaluate);
}
