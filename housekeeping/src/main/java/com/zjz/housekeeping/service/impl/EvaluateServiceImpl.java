package com.zjz.housekeeping.service.impl;

import com.zjz.housekeeping.dao.EvaluateDao;
import com.zjz.housekeeping.dao.OrderDao;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Evaluate;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:31
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    EvaluateDao evaluateDao;
    @Autowired
    OrderDao orderDao;

    @Override
    public ResultVO add(Evaluate evaluate) {
        evaluateDao.add(evaluate);
        Order order = new Order();
        Evaluate result = evaluateDao.queryById(evaluate.getOrderId());
        order.setOrderId(evaluate.getOrderId());
        order.setEvaluateId(result.getEvaluateId());
        order.setEvaluateTime(evaluate.getEvaluateTime());
        orderDao.update(order);
        return new ResultVO(ResultEnum.SUCCESS,result);
    }

    @Override
    public ResultVO delete(Integer evaluateId) {
        Evaluate u = new Evaluate();
        u.setEvaluateId(evaluateId);
        if (evaluateDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.DELETE_FAIL, "用户不存在");
        } else {
            evaluateDao.delete(evaluateId);
            return new ResultVO(ResultEnum.DELETE_SUCCESS,"删除成功");
        }
    }

    @Override
    public ResultVO update(Evaluate evaluate) {
        Evaluate u = new Evaluate();
        u.setEvaluateId(evaluate.getEvaluateId());
        if (evaluateDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "用户不存在");
        } else {
            evaluateDao.update(evaluate);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,evaluate);
        }
    }

    @Override
    public ResultVO queryById(Integer orderId) {
        return new ResultVO(ResultEnum.SUCCESS,evaluateDao.queryById(orderId));
    }


    @Override
    public ResultVO queryCondition(Evaluate evaluate) {
        List<Evaluate> evaluates = evaluateDao.queryCondition(evaluate);
        return new ResultVO(ResultEnum.SUCCESS,evaluates);
    }
}
