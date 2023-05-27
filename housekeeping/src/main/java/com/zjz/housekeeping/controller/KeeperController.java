package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.module.entity.Keeper;
import com.zjz.housekeeping.module.vo.KeeperVO;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.KeeperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/5 14:25
 */
@RestController
@RequestMapping("/keeper")
@Api(tags = "保姆前端控制器")
public class KeeperController {
    @Autowired
    KeeperService keeperService;
    
    @PostMapping("/login")
    public ResultVO login(@RequestBody Keeper keeper) {
        return keeperService.login(keeper);
    }


    @PostMapping("/register")
    public ResultVO register(@RequestBody Keeper keeper) {
        return keeperService.register(keeper);
    }


    @PostMapping("/updateKeeper")
    @ApiOperation("修改个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keeper", value = "保姆对象", dataType = "keeper"),
    })
    public ResultVO updateKeeper(@RequestBody Keeper keeper){
        return keeperService.update(keeper);
    }



    @GetMapping("/updatePwd")
    @ApiOperation("保姆修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "原密码", dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "String"),
            @ApiImplicitParam(name = "keeperId", value = "保姆Id", dataType = "Integer"),
    })
    public ResultVO updatePwd(String oldPassword, String newPassword, Integer keeperId){
        return this.keeperService.updatePassword(oldPassword,newPassword,keeperId);
    }



    @GetMapping("/queryById/{keeperId}")
    @ApiOperation("Id查询保姆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keeperId", value = "保姆Id", dataType = "Integer"),
    })
    public ResultVO queryById(@PathVariable Integer keeperId) {
        return keeperService.queryById(keeperId);
    }

    @PostMapping("/getAllKeeper")
    @ApiOperation("查询保姆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keeperVO", value = "保姆", dataType = "keeperVO"),
    })
    public ResultVO getAllkeeper(@RequestBody KeeperVO keeperVO) {
        return keeperService.getAllKeeper(keeperVO);
    }

    @PostMapping("/queryCondition")
    @ApiOperation("条件查询")
    @ApiImplicitParam(name = "keeper",value = "保姆",dataType = "keeper")
    public ResultVO queryCondition(@RequestBody Keeper keeper){
        return keeperService.queryCondition(keeper);
    }

    @PostMapping("/deleteKeeper/{keeperId}")
    @ApiOperation("删除保姆")
    @ApiImplicitParam(name = "keeperId",value = "保姆id",dataType = "Integer")
    public ResultVO deleteKeeper(@PathVariable Integer keeperId){
        return keeperService.delete(keeperId);
    }

    @GetMapping("/getOrder/{keeperId}")
    @ApiOperation("Id查询服务人员订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keeperId", value = "服务人员Id", dataType = "Integer"),
    })
    public ResultVO queryOrder(@PathVariable Integer keeperId) {
        return keeperService.getOrder(keeperId);
    }
}
