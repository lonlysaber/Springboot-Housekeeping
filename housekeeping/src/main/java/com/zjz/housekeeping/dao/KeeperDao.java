package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.Keeper;
import com.zjz.housekeeping.module.entity.User;
import com.zjz.housekeeping.module.vo.KeeperVO;
import com.zjz.housekeeping.module.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KeeperDao {
    void add(Keeper keeper);

    void delete(Integer keeperId);

    Keeper queryById(Integer keeperId);

    void update(Keeper keeper);

    List<Keeper> queryCondition(Keeper keeper);

    List<Keeper> queryBySelectActive(KeeperVO keeperVO);

    Integer countBySelectActive(KeeperVO keeperVO);

    List<Keeper> getKeeperRecommend(Integer keeperId);//个性推荐

    List<Integer> getCartCategory(Integer userId);

    List<Integer> getCollectCategory(Integer userId);
}
