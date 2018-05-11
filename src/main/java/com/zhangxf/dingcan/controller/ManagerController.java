package com.zhangxf.dingcan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangxf.dingcan.pojo.Manager;
import com.zhangxf.dingcan.service.ManagerService;


@Controller
@RequestMapping("/manage")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/get")
	@ResponseBody
	public Manager get() {
		Manager user = managerService.findById(1);
		return user;
	}

	@RequestMapping("/post")
	@ResponseBody
	public Manager post() {
		
		Manager manager = new Manager();
		manager.setName("zhangsan");
		manager.setEmail("2532466428@");
		managerService.insert(manager);
		return manager;
	}
	
	@RequestMapping("/put")
	@ResponseBody
	public Manager put() {
		
		Manager manager = new Manager();
		manager.setId(1);
		manager.setEmail("2532466428@222222");
		managerService.update(manager);
		return manager;
	}
	
}
