package com.zhangxf.dingcan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangxf.dingcan.pojo.Test;
import com.zhangxf.dingcan.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/get")
	public List<Test> getList(){
		
		return testService.getList();
	}
	@RequestMapping("/set")
	public void set(){
		for (int i = 0; i < 10; i++) {
			Test test=new Test();
			test.setUsername("name"+i);
			testService.add(test);
		
		}
	}
	
}
