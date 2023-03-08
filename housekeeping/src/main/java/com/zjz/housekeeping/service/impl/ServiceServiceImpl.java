package com.zjz.housekeeping.service.impl;

import com.zjz.housekeeping.dao.ServiceDao;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Service;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.module.vo.ServiceVO;
import com.zjz.housekeeping.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


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
            return new ResultVO(ResultEnum.DELETE_FAIL, "服务不存在");
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
            return new ResultVO(ResultEnum.UPDATE_FAIL, "服务不存在");
        } else {
            serviceDao.update(service);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,service);
        }
    }

    @Override
    public ResultVO queryById(Integer serviceId) {
        return new ResultVO(ResultEnum.SUCCESS,serviceDao.queryById(serviceId));
    }

    @Override
    public ResultVO getAllService(Service service) {
        List<ServiceVO>  resultArray = new ArrayList<>();
        List<Service> serviceArray = serviceDao.getAllService(service);
        Integer index = 0;
        for (Service service1:serviceArray) {
            ServiceVO serviceVO = new ServiceVO();
            Boolean isEqual = false;
            if(!resultArray.isEmpty()){
                //如果已经存在当前大类，直接将小类添加
                if(resultArray.get(resultArray.size()-1).getServiceBigType().equals(service1.getServiceBigType())){
                    List<String> tmp = resultArray.get(resultArray.size()-1).getServiceSmallType();
                    tmp.add(service1.getServiceSmallType());
                    resultArray.get(resultArray.size()-1).setServiceSmallType(tmp);
                    isEqual = true;
                }
            }
//            当前大类不存在，添加大类加小类
            if(!isEqual){
                serviceVO.setIndex(index++);
                serviceVO.setServiceBigType(service1.getServiceBigType());
                List<String> tmp = new ArrayList<>();
                tmp.add(service1.getServiceSmallType());
                serviceVO.setServiceSmallType(tmp);
                resultArray.add(serviceVO);
            }

        }
        return new ResultVO(ResultEnum.SUCCESS,resultArray);
    }

    @Override
    public ResultVO queryCondition(Service service) {
        return null;
    }
}
