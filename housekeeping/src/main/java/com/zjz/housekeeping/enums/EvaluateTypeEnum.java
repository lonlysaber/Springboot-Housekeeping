package com.zjz.housekeeping.enums;

import lombok.Getter;

@Getter
public enum EvaluateTypeEnum {
    ety0(0,"暂无评价"),
    ety1(1,"暂无评价"),
    ety2(2,"暂无评价"),
    ety3(3,"暂无评价"),
    ety4(4,"暂无评价"),
    ety5(5,"暂无评价"),
    ety6(6,"已评价");

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
