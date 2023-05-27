package com.zjz.housekeeping.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjz.housekeeping.dao.KeeperDao;
import com.zjz.housekeeping.enums.EvaluateTypeEnum;
import com.zjz.housekeeping.enums.OrderTypeEnum;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Keeper;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.entity.TimeSlot;
import com.zjz.housekeeping.module.vo.KeeperVO;
import com.zjz.housekeeping.module.vo.PageBeans;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/4 16:09
 */
@Service
public class KeeperServiceImpl implements KeeperService {
    @Autowired
    KeeperDao keeperDao;

    @Override
    public void add(Keeper keeper) {
        keeperDao.add(keeper);
    }

    @Override
    public ResultVO delete(Integer keeperId) {
        Keeper k = new Keeper();
        k.setKeeperId(keeperId);
        if (keeperDao.queryCondition(k).isEmpty()) {
            return new ResultVO(ResultEnum.DELETE_FAIL, "用户不存在");
        } else {
            keeperDao.delete(keeperId);
            return new ResultVO(ResultEnum.DELETE_SUCCESS,"删除成功");
        }
    }

    @Override
    public ResultVO update(Keeper keeper) {
        Keeper k = new Keeper();
        k.setKeeperId(keeper.getKeeperId());
        if (keeperDao.queryCondition(k).isEmpty()) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "用户不存在");
        } else {
            keeperDao.update(keeper);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,keeper);
        }
    }

    @Override
    public ResultVO queryById(Integer keeperId) {
        return new ResultVO(ResultEnum.SUCCESS,keeperDao.queryById(keeperId));
    }

    @Override
    public ResultVO register(Keeper keeper) {
        Keeper k = new Keeper();

        k.setKeeperName(keeper.getKeeperName());

        List<Keeper> list = keeperDao.queryCondition(k);
        if (list.isEmpty()) {
            k.setKeeperPwd(keeper.getKeeperPwd());
            keeperDao.add(k);
            return new ResultVO(ResultEnum.SUCCESS, k);
        } else {
            return new ResultVO(ResultEnum.FAIL, "该账号已存在");
        }
    }

    @Override
    public ResultVO login(Keeper keeper) {
        Keeper k = new Keeper();

        k.setKeeperName(keeper.getKeeperName());
        k.setKeeperPhone(keeper.getKeeperPhone());

        List<Keeper> list = keeperDao.queryCondition(k);
        if (list == null || list.isEmpty()) {
            return new ResultVO(ResultEnum.FAIL, "该账号不存在");
        } else if (list.get(0).getKeeperPwd().equals(keeper.getKeeperPwd())) {
            return new ResultVO(ResultEnum.SUCCESS,list.get(0));
        } else {
            return new ResultVO(ResultEnum.FAIL, "密码错误");
        }
    }

    @Override
    public ResultVO queryCondition(Keeper keeper) {
        List<Keeper> keepers = keeperDao.queryCondition(keeper);
        if(keepers.isEmpty())
            return new ResultVO(ResultEnum.FAIL,keepers);
        else
            return new ResultVO(ResultEnum.SUCCESS,keepers);
    }

    @Override
    public ResultVO getOrder(Integer keeperId) {
        List<Order> orders = keeperDao.getOrder(keeperId);
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
    public ResultVO updatePassword(String oldPassword, String newPassword, Integer keeperId) {
        Keeper k = keeperDao.queryById(keeperId);
        if (k == null) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "该用户不存在");
        } else if (k.getKeeperPwd().equals(oldPassword)) {
            k.setKeeperPwd(newPassword);
            keeperDao.update(k);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,"密码修改成功");
        } else {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "密码错误");
        }
    }

    @Override
    public void updateAvatar() {

    }



    @Override
    public ResultVO getCollect(Integer keeperId) {
        return null;
    }

    @Override
    public ResultVO getEvaluate(Integer keeperId) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param keeperVO
     * @return
     */



    @Override
    public ResultVO getAllKeeper(KeeperVO keeperVO) {
        PageBeans pageBeans = new PageBeans();
        pageBeans.setCurrentPage(keeperVO.getCurrentPage());
        pageBeans.setPageSize(keeperVO.getPageSize());
        pageBeans.setCount(keeperDao.countBySelectActive(keeperVO));
        pageBeans.setData(keeperDao.queryBySelectActive(keeperVO));
        return new ResultVO(ResultEnum.SUCCESS, pageBeans);
    }
}
