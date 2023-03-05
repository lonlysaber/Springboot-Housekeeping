package com.zjz.housekeeping.module.vo;


import com.zjz.housekeeping.module.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:甘舟
 * Data:2022/9/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO extends User {
//    分页查询的两个参数
    private Integer currentPage;
    private Integer pageSize;
}
