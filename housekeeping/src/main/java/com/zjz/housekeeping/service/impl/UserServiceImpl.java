package com.zjz.housekeeping.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjz.housekeeping.dao.UserDao;
import com.zjz.housekeeping.enums.EvaluateTypeEnum;
import com.zjz.housekeeping.enums.OrderTypeEnum;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.entity.TimeSlot;
import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.PageBeans;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.module.vo.UserVO;
import com.zjz.housekeeping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/1 14:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public ResultVO delete(Integer userId) {
        User u = new User();
        u.setUserId(userId);
        if (userDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.DELETE_FAIL, "用户不存在");
        } else {
            userDao.delete(userId);
            return new ResultVO(ResultEnum.DELETE_SUCCESS,"删除成功");
        }
    }

    @Override
    public ResultVO update(User user) {
        User u = new User();
        u.setUserId(user.getUserId());
        if (userDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "用户不存在");
        } else {
            userDao.update(user);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,user);
        }
    }

    @Override
    public ResultVO queryById(Integer userId) {
        return new ResultVO(ResultEnum.SUCCESS,userDao.queryById(userId));
    }

    @Override
    public ResultVO register(User user) {
        User u = new User();

        u.setUserName(user.getUserName());

        List<User> list = userDao.queryCondition(u);
        if (list.isEmpty()) {
            u.setUserPwd(user.getUserPwd());
            userDao.add(u);
            return new ResultVO(ResultEnum.SUCCESS, u);
        } else {
            return new ResultVO(ResultEnum.FAIL, "该账号已存在");
        }
    }

    @Override
    public ResultVO login(User user) {
        User u = new User();
//        if(user.getUserPhone().equals(u.getUserPhone()) || user.getUserName().equals(u.getUserName())){
//            return new ResultVO(ResultEnum.FAIL, "必要参数缺失");
//        }
        u.setUserName(user.getUserName());
        u.setUserPhone(user.getUserPhone());

        List<User> list = userDao.queryCondition(u);
        if (list == null || list.isEmpty()) {
            return new ResultVO(ResultEnum.FAIL, "该账号不存在");
        } else if (list.get(0).getUserPwd().equals(user.getUserPwd())) {
            return new ResultVO(ResultEnum.SUCCESS,list.get(0));
        } else {
            return new ResultVO(ResultEnum.FAIL, "密码错误");
        }
    }

    @Override
    public ResultVO queryCondition(User user) {
        List<User> users = userDao.queryCondition(user);
        if(users.isEmpty())
            return new ResultVO(ResultEnum.FAIL,users);
        else
            return new ResultVO(ResultEnum.SUCCESS,users);
    }

    @Override
    public ResultVO updatePassword(String oldPassword, String newPassword, Integer userId) {
        User u = userDao.queryById(userId);
        if (u == null) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "该用户不存在");
        } else if (u.getUserPwd().equals(oldPassword)) {
            u.setUserPwd(newPassword);
            userDao.update(u);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,"密码修改成功");
        } else {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "密码错误");
        }
    }

    @Override
    public void updateAvatar() {

    }

    @Override
    public ResultVO getOrder(Integer userId) {
        List<Order> orders = userDao.getOrder(userId);
        for (Order order1 : orders) {
            //       json转化为java对象
            String jsonData = order1.timeSlot; //json格式的字符串
            TimeSlot timeSlot = JSONObject.parseObject(jsonData, TimeSlot.class);
            order1.timeSlotObj = timeSlot;
//            OrderTypeEnum orderTypeEnum = new OrderTypeEnum(0);
//            枚举类替换 订单状态
            order1.setStatusDes(OrderTypeEnum.toDescribe(order1.getStatus()));
//            枚举类替换 评价状态
            order1.setEvaluateDes(EvaluateTypeEnum.toDescribe(order1.getStatus()));
        }
        if(orders.isEmpty())
            return new ResultVO(ResultEnum.FAIL,orders);
        else
            return new ResultVO(ResultEnum.SUCCESS,orders);
    }

    @Override
    public ResultVO getCollect(Integer userId) {
        return null;
    }

    @Override
    public ResultVO getEvaluate(Integer uerId) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param userVO
     * @return
     */

    @Override
    public ResultVO getAllUser(UserVO userVO) {
        PageBeans pageBeans = new PageBeans();
        pageBeans.setCurrentPage(userVO.getCurrentPage());
        pageBeans.setPageSize(userVO.getPageSize());
        pageBeans.setCount(userDao.countBySelectActive(userVO));
        pageBeans.setData(userDao.queryBySelectActive(userVO));
        return new ResultVO(ResultEnum.SUCCESS, pageBeans);
    }
}
