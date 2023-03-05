package com.zjz.housekeeping.service;

import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.ResultVO;
import com.zjz.housekeeping.module.vo.UserVO;

public interface UserService {
    void add(User user);

    ResultVO delete(Integer userId);

    ResultVO update(User user);

    ResultVO queryById(Integer userId);

    ResultVO register(User user);

    ResultVO login(User user);

    ResultVO queryCondition(User user);

    ResultVO updatePassword(String oldPassword, String newPassword,Integer userId);

    void updateAvatar();//更新头像

    ResultVO getOrder(Integer userId);

    ResultVO getCollect(Integer userId);

    ResultVO getEvaluate(Integer uerId);

    ResultVO getAllUser(UserVO userVO);

//    ResultVO getUserRecommend(Integer userId);//个性推荐
}
