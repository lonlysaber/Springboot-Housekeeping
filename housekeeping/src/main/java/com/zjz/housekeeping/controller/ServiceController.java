package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.module.entity.Service;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.ServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:28
 */
@RestController
@RequestMapping("/service")
@Api(tags = "服务前端控制器")
public class ServiceController {
    
    @Autowired
    ServiceService serviceService;



    @PostMapping("/updateservice")
    @ApiOperation("修改个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "service", value = "订单对象", dataType = "service"),
    })
    public ResultVO updateservice(@RequestBody Service service){
        return serviceService.update(service);
    }

    @GetMapping("/queryById/{serviceId}")
    @ApiOperation("Id查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId", value = "订单Id", dataType = "Integer"),
    })
    public ResultVO queryById(@PathVariable Integer serviceId) {
        return serviceService.queryById(serviceId);
    }

    @PostMapping("/getAllService")
    @ApiOperation("查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceVO", value = "订单", dataType = "service"),
    })
    public ResultVO getAllService(@RequestBody Service service) {
        return serviceService.getAllService(service);
    }

    @PostMapping("/queryCondition")
    @ApiOperation("条件查询")
    @ApiImplicitParam(name = "service",value = "订单",dataType = "service")
    public ResultVO queryCondition(@RequestBody Service service){
        return serviceService.queryCondition(service);
    }

    @PostMapping("/deleteService/{serviceId}")
    @ApiOperation("删除订单")
    @ApiImplicitParam(name = "serviceId",value = "订单id",dataType = "Integer")
    public ResultVO deleteservice(@PathVariable Integer serviceId){
        return serviceService.delete(serviceId);
    }
    
}
