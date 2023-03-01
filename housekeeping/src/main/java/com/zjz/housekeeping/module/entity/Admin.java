package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 16:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPwd;
}
