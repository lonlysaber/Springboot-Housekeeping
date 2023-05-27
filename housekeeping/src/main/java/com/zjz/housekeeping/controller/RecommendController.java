package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.module.entity.Service;
import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/3/26 16:17
 */
@RestController
@RequestMapping("/recommend")
@Api(tags = "推荐前端控制器")
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    /**
     * 查询热门商品
     * @return
     */
    @PostMapping("/hotRec")
    @ApiOperation("查询热门服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "service", value = "服务", dataType = "service"),
    })
    public ResultVO hotRec(@RequestBody User user) {
        return recommendService.hotRecommend(user);
    }
    /**
     * 用户推荐
     * @return
     */
    @PostMapping("/banner")
    @ApiOperation("查询热门商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "service", value = "服务", dataType = "service"),
    })
    public ResultVO banner(@RequestBody User user) {
//        return recommendService.banner();
        return  recommendService.userRecommend(user);
    }
}
