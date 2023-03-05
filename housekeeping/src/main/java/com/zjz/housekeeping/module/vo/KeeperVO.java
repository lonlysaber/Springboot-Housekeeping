package com.zjz.housekeeping.module.vo;

import com.zjz.housekeeping.module.entity.Keeper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/4 16:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeeperVO extends Keeper {
    private Integer currentPage;
    private Integer pageSize;
}
