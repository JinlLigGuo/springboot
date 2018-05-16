package com.springboot.running.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.running.entity.User;
import com.springboot.running.entity.enums.AgeEnum;
import com.springboot.running.mapper.UserMapper;
import com.springboot.running.service.IUserService;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

	@Override
	public List<User> selectListBySQL() {
		return baseMapper.selectListBySQL();
	}

	@Transactional
	@Override
	public void testTransactional1() {
		baseMapper.insert(new User(1000L, "测试事物1", AgeEnum.ONE, 3));
		System.out.println(" 这里手动抛出异常，自动回滚数据");
	}

	@Transactional
	@Override
	public void testTransactional2() {
		baseMapper.insert(new User(1001L, "测试事物2", AgeEnum.ONE, 3));
		System.out.println(" 这里手动抛出异常，自动回滚数据");
		throw new RuntimeException();
	}

}