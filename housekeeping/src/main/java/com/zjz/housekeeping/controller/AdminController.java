package com.zjz.housekeeping.controller;

import com.zjz.housekeeping.module.entity.Admin;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 20:36
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 登入模块
     * @param admin
     * @return
     */
    @PostMapping("/login")
    public ResultVO login(@RequestBody Admin admin) {
//        ResultVO resultVO = new ResultVO();
//        resultVO.ResultVOa();
        return adminService.login(admin);
    }
}
