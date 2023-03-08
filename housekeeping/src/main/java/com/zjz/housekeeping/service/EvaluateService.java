package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Evaluate;
import com.zjz.housekeeping.module.vo.ResultVO;

public interface EvaluateService {
    ResultVO add(Evaluate evaluate);

    ResultVO delete(Integer evaluateId);

    ResultVO update(Evaluate evaluate);

    ResultVO queryById(Integer evaluateId);

    ResultVO queryCondition(Evaluate evaluate);

}
