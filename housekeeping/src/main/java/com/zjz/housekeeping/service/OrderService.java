package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.vo.OrderVO;
import com.zjz.housekeeping.module.vo.ResultVO;

public interface OrderService {
    void add(Order order);

    ResultVO delete(Integer orderId);

    ResultVO update(Order order);

    ResultVO queryById(Integer orderId);


    ResultVO queryCondition(Order order);


    ResultVO getOrder(Integer orderId);

    ResultVO getCollect(Integer orderId);

    ResultVO getEvaluate(Integer uerId);

    ResultVO getAllOrder(OrderVO orderVO);
}
