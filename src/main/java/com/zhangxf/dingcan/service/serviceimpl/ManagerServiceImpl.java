package com.zhangxf.dingcan.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangxf.dingcan.dao.ManagerMapper;
import com.zhangxf.dingcan.pojo.Manager;
import com.zhangxf.dingcan.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	//这里的单引号不能少，否则会报错，被识别是一个对象;  
    public static final String CACHE_KEY = "'manager'";  
	
	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	//@Cacheable(value="Manager",key="'manager_'+#id")
	@Cacheable(value="Manager",key="#id")
	public Manager findById(int id) {
		Manager manager=managerMapper.selectByPrimaryKey(id);
		System.out.println("--------");
		return manager;
	}

	//测试事物回滚 
	//注意@Transactional只能被应用到public方法上，
	//对于其它非public的方法，如果标记了@Transactional也不会报错,但方法没有事务功能。 
	@Transactional
	@Override
	public void insert(Manager manager) {
		/*for (int i = 0; i < 3; i++) {
		    if(i<2){  
                this.managerMapper.insert(manager); 
                System.out.println(manager.getName());
            }  
            else {  
                throw new RuntimeException();  
            }  
		}*/
		
	}

	@Override
	//@CachePut(value="Manager",key="'manager_'+#manager.getId()")
	@CacheEvict(value="Manager",key="#manager.getId()" )
	public void update(Manager manager) {
		managerMapper.updateByPrimaryKeySelective(manager);
	}

	
}
