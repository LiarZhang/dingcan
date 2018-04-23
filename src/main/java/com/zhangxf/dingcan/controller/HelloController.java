package com.zhangxf.dingcan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangxf.dingcan.pojo.User;
import com.zhangxf.dingcan.service.UserService;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private UserService userService;

	@RequestMapping("/get")
	@ResponseBody
	public User get() {
		User user = userService.findByUsername("soso");
		System.out.println(user.getNikename());
		return user;
	}

}
