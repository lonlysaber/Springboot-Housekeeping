package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.module.entity.Evaluate;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/6 9:27
 */
@RestController
@RequestMapping("/evaluate")
@Api(tags = "评价前端控制器")
public class EvaluateController {
    @Autowired
    EvaluateService evaluateService;
    /**
     * 添加管理员
     * @param evaluate
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "evaluate", value = "评价", dataType = "Evaluate"),
    })
    public ResultVO add(@RequestBody Evaluate evaluate) {
        return evaluateService.add(evaluate);
    }


    @PostMapping("/updateEvaluate")
    @ApiOperation("修改评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "evaluate", value = "评价对象", dataType = "Evaluate"),
    })
    public ResultVO updateEvaluate(@RequestBody Evaluate evaluate){
        return evaluateService.update(evaluate);
    }

    @GetMapping("/queryById/{orderId}")
    @ApiOperation("Id查询评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "evaluateId", value = "评价Id", dataType = "Integer"),
    })
    public ResultVO queryById(@PathVariable Integer orderId) {
        return evaluateService.queryById(orderId);
    }



    @PostMapping("/queryCondition")
    @ApiOperation("条件查询")
    @ApiImplicitParam(name = "Evaluate",value = "评价",dataType = "Evaluate")
    public ResultVO queryCondition(@RequestBody Evaluate evaluate){
        return evaluateService.queryCondition(evaluate);
    }

    @PostMapping("/deleteEvaluate/{evaluateId}")
    @ApiOperation("删除评价")
    @ApiImplicitParam(name = "evaluateId",value = "评价id",dataType = "Integer")
    public ResultVO deleteEvaluate(@PathVariable Integer evaluateId){
        return evaluateService.delete(evaluateId);
    }
}
