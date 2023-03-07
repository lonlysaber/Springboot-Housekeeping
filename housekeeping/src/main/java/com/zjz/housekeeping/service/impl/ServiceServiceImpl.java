package com.zjz.housekeeping.service.impl;

import com.zjz.housekeeping.dao.ServiceDao;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Service;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:32
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceDao serviceDao;

    public void add(Service service) {
        serviceDao.add(service);
    }

    @Override
    public ResultVO delete(Integer serviceId) {
        Service u = new Service();
        u.setServiceId(serviceId);
        if (serviceDao.queryById(serviceId)==null) {
            return new ResultVO(ResultEnum.DELETE_FAIL, "用户不存在");
        } else {
            serviceDao.delete(serviceId);
            return new ResultVO(ResultEnum.DELETE_SUCCESS,"删除成功");
        }
    }

    @Override
    public ResultVO update(Service service) {
        Service u = new Service();
        u.setServiceId(service.getServiceId());
        if (serviceDao.queryById(service.getServiceId())==null) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "用户不存在");
        } else {
            serviceDao.update(service);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,service);
        }
    }

    @Override
    public ResultVO queryById(Integer serviceId) {
        return new ResultVO(ResultEnum.SUCCESS,serviceDao.queryById(serviceId));
    }
}
