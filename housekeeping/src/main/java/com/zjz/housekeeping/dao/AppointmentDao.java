package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppointmentDao {
    void add(Appointment appointment);

    void delete(Integer appointmentId);

    Appointment queryById(Integer appointmentId);

    void update(Appointment appointment);

    List<Appointment> queryCondition(Appointment appointment);
}
