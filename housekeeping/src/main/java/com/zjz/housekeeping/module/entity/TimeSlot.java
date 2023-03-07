package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/7 11:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
    private String start;
    private String end;
}
