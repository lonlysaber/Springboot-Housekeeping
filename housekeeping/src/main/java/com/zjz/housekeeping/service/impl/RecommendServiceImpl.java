package com.zjz.housekeeping.service.impl;

import com.zjz.housekeeping.dao.OrderDao;
import com.zjz.housekeeping.dao.UserDao;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Keeper;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.entity.Service;
import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/26 16:24
 */
@org.springframework.stereotype.Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    UserDao userDao;

    @Override
    public ResultVO hotRecommend(User user) {
        List<Service> services =  orderDao.hotRecommend(user);
        return new ResultVO(ResultEnum.SUCCESS,services );
    }

    @Override
    public ResultVO userRecommend(User user) {
        List<Keeper> keepers = orderDao.userRecommend(user);
        return  new ResultVO(ResultEnum.SUCCESS,keepers);
    }


}
