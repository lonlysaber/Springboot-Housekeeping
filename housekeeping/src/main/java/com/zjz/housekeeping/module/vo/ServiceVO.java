package com.zjz.housekeeping.module.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/18 14:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceVO {
    private Integer index;
    private String serviceBigType;
    private List<String> serviceSmallType;
}
