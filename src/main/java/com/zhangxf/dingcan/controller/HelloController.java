package com.zhangxf.dingcan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangxf.dingcan.pojo.User;


@Controller
public class HelloController {
	
	@RequestMapping("/get")
	@ResponseBody
	public User get(){
		User user=new User();
		user.setBirthday("1998.01.08");
		user.setUsername("张三");
		System.out.println("121");
		return user;
	}
	
}
