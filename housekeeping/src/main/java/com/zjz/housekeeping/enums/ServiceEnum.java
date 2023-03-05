package com.zjz.housekeeping.enums;

import lombok.Getter;

@Getter
public enum ServiceEnum {
    ser0(0,"家政服务","大扫除新"),
    ser1(1,"家政服务","保洁做饭"),
    ser2(2,"家政服务","日常保洁"),
    ser3(3,"家政服务","地板打蜡"),
    ser4(4,"家政服务","地毯清洗"),
    ser5(5,"家政服务","厨房保洁"),
    ser6(6,"家政服务","小时保洁"),
    ser7(7,"家政服务","精擦玻璃"),
    ser8(8,"家政服务","开荒保洁"),
    ser9(9,"家政服务","厕所保洁"),
    ser10(10,"家电清洗","洗衣机清洗"),
    ser11(11,"家电清洗","热水器清洗"),
    ser12(12,"家电清洗","空调清洗"),
    ser13(13,"家电清洗","地暖清洗"),
    ser14(14,"家电清洗","冰箱清洗"),
    ser15(15,"家电清洗","油烟机清洗"),
    ser16(16,"温馨保姆","保姆"),
    ser17(17,"温馨保姆","育婴师"),
    ser18(18,"温馨保姆","月嫂");

    private Integer sid;
    private String big;
    private String small;

    private ServiceEnum(Integer sid,String big,String small){
        this.sid = sid;
        this.big = big;
        this.small = small;
    }
}
