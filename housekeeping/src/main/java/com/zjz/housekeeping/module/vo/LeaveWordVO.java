package com.zjz.housekeeping.module.vo;

import com.zjz.housekeeping.module.entity.LeaveWord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/5/19 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveWordVO extends LeaveWord {
    //    分页查询的两个参数
    private Integer currentPage;
    private Integer pageSize;
}
