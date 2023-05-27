package com.zjz.housekeeping.service.impl;

import com.zjz.housekeeping.dao.LeaveWordDao;
import com.zjz.housekeeping.enums.ResultEnum;
import com.zjz.housekeeping.module.entity.LeaveWord;
import com.zjz.housekeeping.module.entity.Order;
import com.zjz.housekeeping.module.vo.LeaveWordVO;
import com.zjz.housekeeping.module.vo.PageBeans;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.module.vo.UserVO;
import com.zjz.housekeeping.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张进哲
 * @version 1.0
 * @date 2023/5/4 18:18
 */
@Service
public class LeaveWordServiceImpl implements LeaveWordService {
    @Autowired
    LeaveWordDao leaveWordDao;

    @Override
    public ResultVO add(LeaveWord leaveWord) {
        leaveWordDao.add(leaveWord);
        List<LeaveWord> result = leaveWordDao.queryCondition(leaveWord);
        return new ResultVO(ResultEnum.SUCCESS,result.get(0));
    }

    @Override
    public ResultVO delete(Integer leaveWordId) {
        LeaveWord u = new LeaveWord();
        u.setLeaveWordId(leaveWordId);
        if (leaveWordDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.DELETE_FAIL, "留言不存在");
        } else {
            leaveWordDao.delete(leaveWordId);
            return new ResultVO(ResultEnum.DELETE_SUCCESS,"删除成功");
        }
    }

    @Override
    public ResultVO update(LeaveWord leaveWord) {
        LeaveWord u = new LeaveWord();
        u.setLeaveWordId(leaveWord.getLeaveWordId());
        if (leaveWordDao.queryCondition(u).isEmpty()) {
            return new ResultVO(ResultEnum.UPDATE_FAIL, "留言不存在");
        } else {
            leaveWordDao.update(leaveWord);
            return new ResultVO(ResultEnum.UPDATE_SUCCESS,leaveWord);
        }
    }

    @Override
    public ResultVO queryById(Integer leaveWordId) {
        return new ResultVO(ResultEnum.SUCCESS,leaveWordDao.queryById(leaveWordId));
    }


    @Override
    public ResultVO queryCondition(LeaveWord leaveWord) {
        List<LeaveWord> leaveWords = leaveWordDao.queryCondition(leaveWord);
        return new ResultVO(ResultEnum.SUCCESS,leaveWords);
    }

    @Override
    public ResultVO getAllLeaveWord(LeaveWordVO leaveWordVO) {
        PageBeans pageBeans = new PageBeans();
        pageBeans.setCurrentPage(leaveWordVO.getCurrentPage());
        pageBeans.setPageSize(leaveWordVO.getPageSize());
        pageBeans.setCount(leaveWordDao.countBySelectActive(leaveWordVO));
        pageBeans.setData(leaveWordDao.queryBySelectActive(leaveWordVO));
        return new ResultVO(ResultEnum.SUCCESS, pageBeans);
    }
}
