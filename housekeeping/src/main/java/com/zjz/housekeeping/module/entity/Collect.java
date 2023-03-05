package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/4 13:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
    private Integer collectId;
    private Integer userId;
    private Integer keeperId;

}
