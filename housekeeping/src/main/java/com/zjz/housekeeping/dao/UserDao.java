package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    void add(User user);

    void delete(Integer userId);

    User queryById(Integer userId);

    void update(User user);

    List<User> queryCondition(User user);

    List<User> queryBySelectActive(UserVO userVO);

    Integer countBySelectActive(UserVO userVO);

    List getUserRecommend(Integer userId);//个性推荐

    List<Integer> getCartCategory(Integer userId);

    List<Integer> getCollectCategory(Integer userId);
}
