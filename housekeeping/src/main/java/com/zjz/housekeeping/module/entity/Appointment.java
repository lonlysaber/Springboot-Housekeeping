package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 16:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Integer appointment;
    private Integer keeperId;
    private Date appointmentTime;
    private String timeSlot;
    private String appointmentSum;
}
