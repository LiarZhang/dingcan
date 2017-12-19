package com.zhangxf.dingcan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangxf.dingcan.pojo.User;


@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/get")
	@ResponseBody
	public User get(){
		User user=new User();
		user.setBirthday("1998.01.08");
		user.setUsername("张三");
		return user;
	}
}
