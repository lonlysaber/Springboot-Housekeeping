package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.module.vo.OrderVO;
import com.zjz.housekeeping.service.OrderService;
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
@RequestMapping("/order")
@Api(tags = "订单前端控制器")
public class OrderController {
    @Autowired
    OrderService orderService;
    /**
     * 添加管理员
     * @param order
     * @return
     */
    @GetMapping("/add")
    @ApiOperation("添加订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", value = "订单", dataType = "Order"),
    })
    public ResultVO add(@RequestBody Order order) {
        orderService.add(order);

        return new ResultVO(ResultEnum.ADD_SUCCESS,order);
    }


    @PostMapping("/updateOrder")
    @ApiOperation("修改个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", value = "订单对象", dataType = "Order"),
    })
    public ResultVO updateOrder(@RequestBody Order order){
        return orderService.update(order);
    }

    @GetMapping("/queryById/{orderId}")
    @ApiOperation("Id查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单Id", dataType = "Integer"),
    })
    public ResultVO queryById(@PathVariable Integer orderId) {
        return orderService.queryById(orderId);
    }

    @PostMapping("/getAllOrder")
    @ApiOperation("查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderVO", value = "订单", dataType = "OrderVO"),
    })
    public ResultVO getAllOrder(@RequestBody OrderVO orderVO) {
        return orderService.getAllOrder(orderVO);
    }

    @PostMapping("/queryCondition")
    @ApiOperation("条件查询")
    @ApiImplicitParam(name = "Order",value = "订单",dataType = "Order")
    public ResultVO queryCondition(@RequestBody Order order){
        return orderService.queryCondition(order);
    }

    @PostMapping("/deleteOrder/{orderId}")
    @ApiOperation("删除订单")
    @ApiImplicitParam(name = "orderId",value = "订单id",dataType = "Integer")
    public ResultVO deleteOrder(@PathVariable Integer orderId){
        return orderService.delete(orderId);
    }

}
