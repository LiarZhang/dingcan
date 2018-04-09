package com.zhangxf.dingcan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zhangxf.dingcan.pojo.User;

/*
 * @date: 2017年12月22日
 * @author: Zhangxf
 * @version :1.0.0
*/
//
@Mapper
public interface UserDao {
	@Select("select * from u_user where id=#{id}")
	public User findById(int id);
	
	@Select("select * from u_user where nikename=#{nikename}")
	public User findByUsername(String nikename);
}
