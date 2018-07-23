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
	public Manager get(String id) {
		
		Manager user = managerService.findById(id);
		return user;
	}

	@PostMapping
	@ApiOperation(value="添加管理用户")
	public Manager post(Manager manager) {
		
		managerService.insert(manager);
		return manager;
	}
	
	@PutMapping
	@ApiOperation(value="更新用户信息")
	public Manager put(Manager manager) {
		
		managerService.update(manager);
		return manager;
	}
	
}
