package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date createTime;
    private Integer money;
    private Date payTime;
    private Integer evaluateId;
    private Date evaluateTime;
    private String endType;

}
