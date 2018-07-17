package com.zhangxf.dingcan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangxf.dingcan.pojo.User;
import com.zhangxf.dingcan.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private UserService userService;

	@GetMapping("/get")
	@ApiOperation(value="查询用户信息")
	public User get() {
		User user = userService.findByUsername("soso");
		return user;
	}

}
