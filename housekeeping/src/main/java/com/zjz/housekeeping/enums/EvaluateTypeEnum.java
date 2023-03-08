package com.zjz.housekeeping.enums;

import lombok.Getter;

@Getter
public enum EvaluateTypeEnum {
    ety1(0,"------"),
    ety2(1,"暂无评价"),
    ety3(2,"默认好评"),
    ety4(3,"已评价");

    private Integer eid;
    private String eDes;

    EvaluateTypeEnum(Integer eid,String eDes){
        this.eid = eid;
        this.eDes = eDes;
    }
    public static String toDescribe(Integer oStatus){
//        获取所有枚举类
        EvaluateTypeEnum[] evaluateTypeEnums = values();
        for(EvaluateTypeEnum evaluateTypeEnum:evaluateTypeEnums){
            if(evaluateTypeEnum.getEid().equals(oStatus)){
                return evaluateTypeEnum.getEDes();
            }
        }
        return null;
    }
}
