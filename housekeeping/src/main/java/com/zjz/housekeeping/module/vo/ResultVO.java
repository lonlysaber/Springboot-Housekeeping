package com.zjz.housekeeping.module.vo;

import com.zjz.housekeeping.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 16:18
 */
@Data
public class ResultVO<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    // 封装 code ，message 和 data
    public ResultVO(ResultEnum resultEnum,T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public ResultVO(T data) {
        this.data = data;
    }
}
