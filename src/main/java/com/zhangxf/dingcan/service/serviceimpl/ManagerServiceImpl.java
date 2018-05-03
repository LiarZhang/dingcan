package com.zhangxf.dingcan.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangxf.dingcan.dao.ManagerMapper;
import com.zhangxf.dingcan.pojo.Manager;
import com.zhangxf.dingcan.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public Manager findById(int id) {
		return managerMapper.selectByPrimaryKey(id);
	}

	
}
