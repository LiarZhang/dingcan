package com.zhangxf.dingcan.service;

import java.util.List;

import com.zhangxf.dingcan.pojo.Test;

public interface TestService {

	public int add(Test test);
	
	public  List<Test> getList();
}
