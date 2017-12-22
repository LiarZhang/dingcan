package com.zhangxf.dingcan.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangxf.dingcan.pojo.User;


@Controller
public class HelloController {
	private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping("/get")
	@ResponseBody
	public User get(){
		User user=new User();
		/*user.setBirthday("1998.01.08");
		user.setUsername("张三");*/
		LOG.info("执行helloController");
		return user;
	}
	
}
