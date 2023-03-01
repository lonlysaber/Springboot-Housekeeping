package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
    void add(Admin admin);

    void delete(Integer id);

    void update(Admin admin);

    Admin queryById(Integer id);

    List<Admin> queryCondition(Admin admin);
}
