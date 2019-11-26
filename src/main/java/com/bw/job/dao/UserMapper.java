package com.bw.job.dao;

import java.util.List;

import com.bw.job.domain.Position;
import com.bw.job.domain.User;
import com.bw.job.vo.UserVO;

public interface UserMapper {


    int insertSelective(User record);

    
    List<User> selects(UserVO userVO);

    /**
     * 
     * @Title: selectsPosition 
     * @Description: 列出所有的职位
     * @return
     * @return: List<Position>
     */
    List<Position> selectsPosition();
    
    /**
     * 
     * @Title: select 
     * @Description: 个人明细
     * @param uid
     * @return
     * @return: User
     */
    User select(Integer uid);

}