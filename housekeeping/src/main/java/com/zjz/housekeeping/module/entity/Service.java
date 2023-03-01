package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private Integer serviceId;
    private String serviceBigType;
    private String serviceSmallType;
}
