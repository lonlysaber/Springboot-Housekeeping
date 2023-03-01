package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Admin;
import com.zjz.housekeeping.module.vo.ResultVO;

import java.util.List;

public interface AdminService {
    void add(Admin admin);

    ResultVO delete(Integer id);

    void update(Admin admin);

    Admin queryId(Integer id);

    List<Admin> queryCodition(Admin admin);

    ResultVO login(Admin admin);
}
