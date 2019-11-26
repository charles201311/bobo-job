package com.bw.job.service;

import java.util.List;

import com.bw.job.domain.Position;
import com.bw.job.domain.Score;
import com.bw.job.domain.User;
import com.bw.job.vo.UserVO;
import com.github.pagehelper.PageInfo;

public interface UserService {
	
	 /**
     * 
     * @Title: select 
     * @Description: 个人明细
     * @param uid
     * @return
     * @return: User
     */
    User select(Integer uid);

	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加应聘者及成绩
	 * @param user
	 * @param score
	 * @return
	 * @return: boolean
	 */
	boolean insert(User user,List<Score> list);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询用户
	 * @param vo
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: PageInfo<User>
	 */
	PageInfo<User> selects(UserVO vo,Integer page,Integer pageSize);
	
	  /**
     * 
     * @Title: selectsPosition 
     * @Description: 列出所有的职位
     * @return
     * @return: List<Position>
     */
    List<Position> selectsPosition();
	
}
