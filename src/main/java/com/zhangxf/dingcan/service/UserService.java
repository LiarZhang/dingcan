package com.zhangxf.dingcan.service;

import com.zhangxf.dingcan.pojo.User;

/*
 * @date: 2017年12月22日
 * @author: Zhangxf
 * @version :1.0.0
*/
public interface UserService {
	public User findById(int id);
	public User findByUsername(String username);
}
