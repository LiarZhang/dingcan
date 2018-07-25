package com.zhangxf.dingcan.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangxf.dingcan.mapper.UserDao;
import com.zhangxf.dingcan.pojo.User;
import com.zhangxf.dingcan.service.UserService;

/*
 * @date: 2017年12月22日
 * @author: Zhangxf
 * @version :1.0.0
*/
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
