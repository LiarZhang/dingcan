package com.zhangxf.dingcan.service;

import com.zhangxf.dingcan.pojo.Manager;

public interface ManagerService {

	public Manager findById(String id);
	
	public void insert(Manager manager);
	
	public Manager update(Manager manager);
	
}
