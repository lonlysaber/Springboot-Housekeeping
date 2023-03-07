package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    void add(Order order);

    void delete(Integer orderId);

    Order queryById(Integer orderId);

    void update(Order order);

    List<Order> queryCondition(Order order);

    List<Order> queryBySelectActive(OrderVO orderVO);

    Integer countBySelectActive(OrderVO orderVO);

}
