package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.module.vo.UserVO;
import com.zjz.housekeeping.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/1 14:12
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户前端控制器")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody User user) {
        return userService.login(user);
    }


    @PostMapping("/register")
    public ResultVO register(@RequestBody User user) {
        return userService.register(user);
    }


    @PostMapping("/updateUser")
    @ApiOperation("修改个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", dataType = "User"),
    })
    public ResultVO updateUser(@RequestBody User user){
        return userService.update(user);
    }



    @GetMapping("/updatePwd")
    @ApiOperation("用户修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "原密码", dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "Integer"),
    })
    public ResultVO updatePwd(String oldPassword, String newPassword, Integer userId){
        return this.userService.updatePassword(oldPassword,newPassword,userId);
    }



    @GetMapping("/queryById/{userId}")
    @ApiOperation("Id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "Integer"),
    })
    public ResultVO queryById(@PathVariable Integer userId) {
        return userService.queryById(userId);
    }

    @PostMapping("/getAllUser")
    @ApiOperation("查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userVO", value = "用户", dataType = "UserVO"),
    })
    public ResultVO getAllUser(@RequestBody UserVO userVO) {
        return userService.getAllUser(userVO);
    }

    @PostMapping("/queryCondition")
    @ApiOperation("条件查询")
    @ApiImplicitParam(name = "User",value = "用户",dataType = "User")
    public ResultVO queryCondition(@RequestBody User user){
        return userService.queryCondition(user);
    }

    @PostMapping("/deleteUser/{userId}")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "userId",value = "用户id",dataType = "Integer")
    public ResultVO deleteUser(@PathVariable Integer userId){
        return userService.delete(userId);
    }


}
