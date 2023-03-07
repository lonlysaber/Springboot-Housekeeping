package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluate {
    private Integer evaluateId;
    private Integer orderId;
    private Integer userId;
    private Integer keeperId;
    private String evaluateStar;
    private String evaluateDetail;
    private Date evaluateTime;
    private User user;
    private Keeper keeper;
}
