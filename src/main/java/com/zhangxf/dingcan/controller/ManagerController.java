package com.zhangxf.dingcan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangxf.dingcan.pojo.Manager;
import com.zhangxf.dingcan.service.ManagerService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/manage")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@GetMapping
	@ApiOperation(value="查询管理用户")
	public Manager get() {
		Manager user = managerService.findById(1);
		return user;
	}

	@PostMapping
	@ApiOperation(value="添加管理用户")
	public Manager post() {
		
		Manager manager = new Manager();
		manager.setName("zhangsan");
		manager.setEmail("2532466428@");
		managerService.insert(manager);
		return manager;
	}
	
	@PutMapping
	@ApiOperation(value="更新用户信息")
	public Manager put() {
		
		Manager manager = new Manager();
		manager.setId(1);
		manager.setEmail("2532466428@222222");
		managerService.update(manager);
		return manager;
	}
	
}
