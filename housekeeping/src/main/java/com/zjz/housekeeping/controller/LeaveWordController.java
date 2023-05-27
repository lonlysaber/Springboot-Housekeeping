package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.module.entity.LeaveWord;
import com.zjz.housekeeping.module.vo.LeaveWordVO;
import com.zjz.housekeeping.module.vo.OrderVO;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.LeaveWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/5/19 9:04
 */
@RestController
@RequestMapping("/leaveWord")
@Api(tags = "留言前端控制器")
public class LeaveWordController {
    @Autowired
    LeaveWordService leaveWordService;
    /**
     * 添加留言
     * @param leaveWord
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "leaveWord", value = "留言", dataType = "LeaveWord"),
    })
    public ResultVO add(@RequestBody LeaveWord leaveWord) {
        return leaveWordService.add(leaveWord);
    }


    @PostMapping("/updateLeaveWord")
    @ApiOperation("修改留言信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "leaveWord", value = "留言对象", dataType = "LeaveWord"),
    })
    public ResultVO updateLeaveWord(@RequestBody LeaveWord leaveWord){
        return leaveWordService.update(leaveWord);
    }

    @GetMapping("/queryById/{leaveWordId}")
    @ApiOperation("Id查询留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "leaveWordId", value = "留言Id", dataType = "Integer"),
    })
    public ResultVO queryById(@PathVariable Integer leaveWordId) {
        return leaveWordService.queryById(leaveWordId);
    }


    @PostMapping("/queryCondition")
    @ApiOperation("条件查询")
    @ApiImplicitParam(name = "LeaveWord",value = "留言",dataType = "LeaveWord")
    public ResultVO queryCondition(@RequestBody LeaveWord leaveWord){
        return leaveWordService.queryCondition(leaveWord);
    }

    @PostMapping("/deleteLeaveWord/{leaveWordId}")
    @ApiOperation("删除留言")
    @ApiImplicitParam(name = "leaveWordId",value = "留言id",dataType = "Integer")
    public ResultVO deleteLeaveWord(@PathVariable Integer leaveWordId){
        return leaveWordService.delete(leaveWordId);
    }

    @PostMapping("/getAllLeaveWord")
    @ApiOperation("分页查询留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "leaveWordVO", value = "留言", dataType = "LeaveWordVO"),
    })
    public ResultVO getAllOrder(@RequestBody LeaveWordVO leaveWordVO) {
        return leaveWordService.getAllLeaveWord(leaveWordVO);
    }
}
