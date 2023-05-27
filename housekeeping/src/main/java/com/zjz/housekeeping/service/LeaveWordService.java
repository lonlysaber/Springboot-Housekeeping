package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Evaluate;
import com.zjz.housekeeping.module.entity.LeaveWord;
import com.zjz.housekeeping.module.vo.LeaveWordVO;
import com.zjz.housekeeping.module.vo.OrderVO;
import com.zjz.housekeeping.module.vo.ResultVO;

public interface LeaveWordService {
    ResultVO add(LeaveWord leaveWord);

    ResultVO delete(Integer leaveWordId);

    ResultVO update(LeaveWord leaveWord);

    ResultVO queryById(Integer leaveWordId);

    ResultVO queryCondition(LeaveWord leaveWord);

    ResultVO getAllLeaveWord(LeaveWordVO leaveWordVO);
}
