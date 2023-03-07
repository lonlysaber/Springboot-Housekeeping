package com.zjz.housekeeping.enums;

import lombok.Getter;

@Getter
public enum OrderTypeEnum {
    oty1(0,"待支付"),
    oty2(1,"已支付"),
    oty3(2,"已支付"),
    oty4(3,"已支付");

    private Integer oStatus;
    private String describe;

    OrderTypeEnum(Integer oStatus, String describe){
        this.describe = describe;
        this.oStatus = oStatus;
    }
    public static String toDescribe(Integer oStatus){
//        获取所有枚举类
        OrderTypeEnum[] orderTypeEnums = values();
        for(OrderTypeEnum orderTypeEnum:orderTypeEnums){
            if(orderTypeEnum.getOStatus().equals(oStatus)){
                return orderTypeEnum.getDescribe();
            }
        }
        return null;
    }
}
