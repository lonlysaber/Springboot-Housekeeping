package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Keeper {
    private Integer keeperId;
    private String keeperName;
    private String keeperPhone;
    private String keeperAvatar;
    private String keeperType;
    private String keeperPwd;
    private String star;
    private String appointment;
    private Integer age;
    private String nativePlace;
    private String feature;
    private String introduce;
    private String years;
    private Date regTime;
}
