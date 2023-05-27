package com.zjz.housekeeping.service.impl;

import com.zjz.housekeeping.dao.AppointmentDao;
import com.zjz.housekeeping.dao.AppointmentDao;
import com.zjz.housekeeping.dao.OrderDao;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Appointment;
import com.zjz.housekeeping.module.entity.Appointment;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:30
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentDao appointmentDao;
    @Autowired
    OrderDao orderDao;

    @Override
    public ResultVO add(Appointment appointment) {
        appointmentDao.add(appointment);
        List<Appointment> result = appointmentDao.queryCondition(appointment);
        return new ResultVO(ResultEnum.SUCCESS,result.get(0));
    }

    @Override
    public ResultVO delete(Integer appointmentId) {
        Appointment u = new Appointment();
        u.setAppointmentId(appointmentId);
        if (appointmentDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.DELETE_FAIL, "用户不存在");
        } else {
            appointmentDao.delete(appointmentId);
            return new ResultVO(ResultEnum.DELETE_SUCCESS,"删除成功");
        }
    }

    @Override
    public ResultVO update(Appointment appointment) {
        Appointment u = new Appointment();
        u.setAppointmentId(appointment.getAppointmentId());
        if (appointmentDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "用户不存在");
        } else {
            appointmentDao.update(appointment);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,appointment);
        }
    }

    @Override
    public ResultVO queryById(Integer orderId) {
        return new ResultVO(ResultEnum.SUCCESS,appointmentDao.queryById(orderId));
    }


    @Override
    public ResultVO queryCondition(Appointment appointment) {
        List<Appointment> appointments = appointmentDao.queryCondition(appointment);
        return new ResultVO(ResultEnum.SUCCESS,appointments);
    }
}
