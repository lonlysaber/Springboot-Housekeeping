package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/5/18 22:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveWord {
    private Integer leaveWordId;
    private Integer orderId;
    private Integer userId;
    private Integer keeperId;
    private String leaveWordType;
    private String leaveWordDetail;
    private String leaveWordStatus;
    private Date leaveWordTime;
    private Date updateTime;
    private User user;
    private Keeper keeper;
}
