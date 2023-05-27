package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.module.entity.Appointment;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.AppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:26
 */
@RestController
@RequestMapping("/appointment")
@Api(tags = "预约前端控制器")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    /**
     * 添加管理员
     * @param appointment
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appointment", value = "预约", dataType = "Appointment"),
    })
    public ResultVO add(@RequestBody Appointment appointment) {
        return appointmentService.add(appointment);
    }


    @PostMapping("/updateAppointment")
    @ApiOperation("修改预约信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appointment", value = "预约对象", dataType = "Appointment"),
    })
    public ResultVO updateAppointment(@RequestBody Appointment appointment){
        return appointmentService.update(appointment);
    }

    @GetMapping("/queryById/{appointmentId}")
    @ApiOperation("Id查询预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appointmentId", value = "预约Id", dataType = "Integer"),
    })
    public ResultVO queryById(@PathVariable Integer appointmentId) {
        return appointmentService.queryById(appointmentId);
    }



    @PostMapping("/queryCondition")
    @ApiOperation("条件查询")
    @ApiImplicitParam(name = "Appointment",value = "评价",dataType = "Appointment")
    public ResultVO queryCondition(@RequestBody Appointment appointment){
        return appointmentService.queryCondition(appointment);
    }

    @PostMapping("/deleteAppointment/{appointmentId}")
    @ApiOperation("删除评价")
    @ApiImplicitParam(name = "appointmentId",value = "评价id",dataType = "Integer")
    public ResultVO deleteAppointment(@PathVariable Integer appointmentId){
        return appointmentService.delete(appointmentId);
    }
}
