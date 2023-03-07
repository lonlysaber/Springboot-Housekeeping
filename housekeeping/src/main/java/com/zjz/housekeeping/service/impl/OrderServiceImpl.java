package com.zjz.housekeeping.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjz.housekeeping.dao.OrderDao;
import com.zjz.housekeeping.enums.OrderTypeEnum;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.entity.TimeSlot;
import com.zjz.housekeeping.module.vo.OrderVO;
import com.zjz.housekeeping.module.vo.PageBeans;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:31
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public ResultVO delete(Integer orderId) {
        Order u = new Order();
        u.setOrderId(orderId);
        if (orderDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.DELETE_FAIL, "用户不存在");
        } else {
            orderDao.delete(orderId);
            return new ResultVO(ResultEnum.DELETE_SUCCESS,"删除成功");
        }
    }

    @Override
    public ResultVO update(Order order) {
        Order u = new Order();
        u.setOrderId(order.getOrderId());
        if (orderDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "用户不存在");
        } else {
            orderDao.update(order);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,order);
        }
    }

    @Override
    public ResultVO queryById(Integer orderId) {
        return new ResultVO(ResultEnum.SUCCESS,orderDao.queryById(orderId));
    }

    
    @Override
    public ResultVO queryCondition(Order order) {
        List<Order> orders = orderDao.queryCondition(order);
        if(orders.isEmpty())
            return new ResultVO(ResultEnum.FAIL,orders);
        else
            return new ResultVO(ResultEnum.SUCCESS,orders);
    }

    @Override
    public ResultVO getOrder(Integer orderId) {
        return null;
    }

    @Override
    public ResultVO getCollect(Integer orderId) {
        return null;
    }

    @Override
    public ResultVO getEvaluate(Integer uerId) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param orderVO
     * @return
     */

    @Override
    public ResultVO getAllOrder(OrderVO orderVO) {
        PageBeans pageBeans = new PageBeans();
        pageBeans.setCurrentPage(orderVO.getCurrentPage());
        pageBeans.setPageSize(orderVO.getPageSize());
        pageBeans.setCount(orderDao.countBySelectActive(orderVO));

        List<Order> orders = orderDao.queryBySelectActive(orderVO);

        //       json转化为java对象
        for(int i = 0;i < orders.size();i++){
            String jsonData = orders.get(i).timeSlot; //json格式的字符串
            TimeSlot timeSlot = JSONObject.parseObject(jsonData, TimeSlot.class);
            orders.get(i).timeSlotObj = timeSlot;
//            OrderTypeEnum orderTypeEnum = new OrderTypeEnum(0);
            orders.get(i).setStatusDes(OrderTypeEnum.toDescribe(orders.get(i).getStatus()));
        }
        pageBeans.setData(orders);

        return new ResultVO(ResultEnum.SUCCESS, pageBeans);
    }
}
