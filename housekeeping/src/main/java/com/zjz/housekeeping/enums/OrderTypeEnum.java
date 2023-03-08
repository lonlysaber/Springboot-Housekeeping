package com.zjz.housekeeping.enums;

import lombok.Getter;

@Getter
public enum OrderTypeEnum {
    oty1(0,"待服务"),
    oty2(1,"服务中"),
    oty3(2,"待支付"),
    oty4(3,"待评价"),
    oty5(4,"已取消"),
    oty6(5,"已退款"),
    ety4(6,"已评价");

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
