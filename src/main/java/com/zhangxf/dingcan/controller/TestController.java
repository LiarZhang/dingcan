package com.zhangxf.dingcan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangxf.dingcan.pojo.Test;
import com.zhangxf.dingcan.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@CacheConfig(cacheNames = "Test")
@RestController
@RequestMapping("/test")
@Api(value="测试API",tags="测试API文档")
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/getList")
	@ApiOperation(value="取得列表")
	@Cacheable(value="Test", keyGenerator = "keyGenerator")
	public List<Test> getList(String username,String sex){
		List<Test> list=testService.getList();
		return list;
	}
	
	
	@GetMapping
	@ApiOperation(value="根据id查询")
	@Cacheable(value="Test", keyGenerator = "keyGenerator")
	public Test getOne(int id){
		Test test= testService.findById(id);
		return test;
	}
	
	@PutMapping
	@ApiOperation(value="更新")
	@CachePut(value="Test",key ="#root.caches[0].name + ':' + #test.getId()")
	public Test update(Test test){
		testService.update(test);
		return test;//返回值更新到Redis
	}
	@ApiIgnore(value="测试接口")//会隐藏接口
	@RequestMapping("/set")
	public void set(){
		for (int i = 0; i < 10; i++) {
			Test test=new Test();
			test.setUsername("name"+i);
			testService.add(test);
		
		}
	}
	
}
