package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Keeper;
import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.ResultVO;

public interface RecommendService {
    ResultVO hotRecommend(User user);
    ResultVO userRecommend(User user);
}
