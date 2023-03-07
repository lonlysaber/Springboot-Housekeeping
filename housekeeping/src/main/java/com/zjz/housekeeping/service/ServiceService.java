package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Service;
import com.zjz.housekeeping.module.vo.ResultVO;

public interface ServiceService {
    void add(Service service);

    ResultVO delete(Integer serviceId);

    ResultVO update(Service service);

    ResultVO queryById(Integer serviceId);
}
