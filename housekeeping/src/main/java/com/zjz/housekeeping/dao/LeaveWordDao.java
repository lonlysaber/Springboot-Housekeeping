package com.zjz.housekeeping.dao;

import com.zjz.housekeeping.module.entity.LeaveWord;
import com.zjz.housekeeping.module.vo.LeaveWordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeaveWordDao {
    void add(LeaveWord leaveWord);

    void delete(Integer leaveWordId);

    LeaveWord queryById(Integer leaveWordId);

    void update(LeaveWord leaveWord);

    List<LeaveWord> queryCondition(LeaveWord leaveWord);

    List<LeaveWord> queryBySelectActive(LeaveWordVO leaveWordVO);

    Integer countBySelectActive(LeaveWordVO userVO);
}
