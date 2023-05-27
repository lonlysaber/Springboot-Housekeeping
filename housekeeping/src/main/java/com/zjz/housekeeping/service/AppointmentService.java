package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Appointment;
import com.zjz.housekeeping.module.vo.ResultVO;

public interface AppointmentService {
    ResultVO add(Appointment appointment);

    ResultVO delete(Integer appointmentId);

    ResultVO update(Appointment appointment);

    ResultVO queryById(Integer appointmentId);

    ResultVO queryCondition(Appointment appointment);
}
