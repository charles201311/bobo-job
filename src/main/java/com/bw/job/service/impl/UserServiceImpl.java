package com.bw.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.job.dao.ScoreMapper;
import com.bw.job.dao.UserMapper;
import com.bw.job.domain.Position;
import com.bw.job.domain.Score;
import com.bw.job.domain.User;
import com.bw.job.service.UserService;
import com.bw.job.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Resource
	private ScoreMapper scoreMapper;

	@Override
	public boolean insert(User user, List<Score> list) {
		try {
			
			userMapper.insertSelective(user);
			for (Score score : list) {
				score.setUid(user.getId());//应聘者
				scoreMapper.insertSelective(score);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败");		}
		
	}

	@Override
	public PageInfo<User> selects(UserVO userVO, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<User> list = userMapper.selects(userVO);

		return new PageInfo<User>(list);
	}

	@Override
	public List<Position> selectsPosition() {
		// TODO Auto-generated method stub
		return userMapper.selectsPosition();
	}

	@Override
	public User select(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.select(uid);
	}

}
