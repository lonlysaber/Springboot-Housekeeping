package com.zjz.housekeeping.service.impl;

import com.zjz.housekeeping.dao.AdminDao;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.Admin;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/2/28 19:44
 */
@Service

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public void add(Admin admin) {

    }

    @Override
    public ResultVO delete(Integer id) {
        return null;
    }

    @Override
    public void update(Admin admin) {

    }

    @Override
    public Admin queryId(Integer id) {
        return null;
    }

    @Override
    public List<Admin> queryCodition(Admin admin) {
        return null;
    }

    @Override
    public ResultVO login(Admin admin) {
        Admin a = new Admin();
        a.setAdminName(admin.getAdminName());

        List<Admin> list = adminDao.queryCondition(a);
        if (list == null || list.isEmpty()) {
            return new ResultVO(ResultEnum.FAIL, "该账号不存在");
        } else if (list.get(0).getAdminPwd().equals(admin.getAdminPwd())) {
            return new ResultVO(ResultEnum.SUCCESS,list.get(0));
        } else {
            return new ResultVO(ResultEnum.FAIL, "密码错误");
        }
    }
}
