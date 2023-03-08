package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 15:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer orderId;
    private Integer userId;
    private Integer keeperId;
    private Integer serviceId;
    public String timeSlot;
    public TimeSlot timeSlotObj;
    private Date createTime;
    private Integer money;
    private Date payTime;
    private Integer evaluateId;
    private Date evaluateTime;
    private Integer status;
    private String statusDes;
    private String evaluateDes;
    private User user;
    private Keeper keeper;
    private String userName;
    private String keeperName;
    private Service service;
    private Evaluate evaluate;


}
