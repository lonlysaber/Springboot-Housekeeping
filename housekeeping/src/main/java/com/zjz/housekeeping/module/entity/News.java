package com.zjz.housekeeping.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private Integer newsId;
    private String newsContent;
    private Date newsTime;
    private String newsOrigin;
}
