package com.zhangxf.dingcan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangxf.dingcan.mapper.TestUserMapper;
import com.zhangxf.dingcan.pojo.TestUser;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("testUser")
public class TestUserController {

	@Autowired
	private TestUserMapper testUserMapper;
	
	@GetMapping
	@ApiOperation(value="根据id查询")
	public TestUser getOne(int id){
		TestUser test=testUserMapper.selectByPrimaryKey(id);
		return test;
	}
}
