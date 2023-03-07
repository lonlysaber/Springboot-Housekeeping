package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.Service;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceDao {
    void add(Service service);

    void delete(Integer serviceId);

    Service queryById(Integer serviceId);

    void update(Service service);
}
