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
    public ResultVO update(Admin admin) {
//        如果账号不存在
        ResultVO adm = queryById(admin.getAdminId());
        if(adm.getCode()==201)
            return new ResultVO(ResultEnum.UPDATE_FAIL,adm.getData());
        else {
            adminDao.update(admin);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,adm.getData());
        }


    }

    @Override
    public ResultVO queryById(Integer id) {
        Admin res = adminDao.queryById(id);
        if(res == null )
            return new ResultVO(ResultEnum.FAIL,"该账号不存在");
        else
            return new ResultVO(ResultEnum.SUCCESS,adminDao.queryById(id));
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
