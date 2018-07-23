package com.zhangxf.dingcan.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhangxf.dingcan.dao.TestMapper;
import com.zhangxf.dingcan.pojo.Test;
import com.zhangxf.dingcan.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public int add(Test test) {
		
		return testMapper.insertSelective(test);
	}

	@Override
	public List<Test> getList() {
		PageHelper.offsetPage(0, 5);
		return testMapper.getList();
	}

	@Override
	public Test findById(int id) {
		return testMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Test test) {
		return testMapper.updateByPrimaryKeySelective(test);
	}

}
