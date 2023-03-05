package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.Keeper;
import com.zjz.housekeeping.module.vo.KeeperVO;
import com.zjz.housekeeping.module.vo.ResultVO;

public interface KeeperService {
    void add(Keeper keeper);

    ResultVO delete(Integer keeperId);

    ResultVO update(Keeper keeper);

    ResultVO queryById(Integer keeperId);

    ResultVO register(Keeper keeper);

    ResultVO login(Keeper keeper);

    ResultVO queryCondition(Keeper keeper);

    ResultVO updatePassword(String oldPassword, String newPassword,Integer keeperId);

    void updateAvatar();//更新头像

    ResultVO getOrder(Integer keeperId);

    ResultVO getCollect(Integer userId);

    ResultVO getEvaluate(Integer keeperId);

    ResultVO getAllKeeper(KeeperVO keeperVO);
}
