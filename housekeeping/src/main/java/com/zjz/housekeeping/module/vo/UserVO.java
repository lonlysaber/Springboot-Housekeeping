package com.zjz.housekeeping.module.vo;

import com.zjz.housekeeping.module.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:36
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO extends User {
//    分页查询的两个参数
    private Integer currentPage;
    private Integer pageSize;
}
