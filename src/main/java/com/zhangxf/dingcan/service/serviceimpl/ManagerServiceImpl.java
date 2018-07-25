package com.zhangxf.dingcan.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangxf.dingcan.mapper.ManagerMapper;
import com.zhangxf.dingcan.pojo.Manager;
import com.zhangxf.dingcan.service.ManagerService;


@CacheConfig(cacheNames = "Manager")
@Service
public class ManagerServiceImpl  /*extends BaseService<Manager>*/ implements ManagerService {

	
	@Autowired
	private ManagerMapper managerMapper;
	//下面两个使用的ehcache缓存
	/*@Override
	//@Cacheable(value="Manager",key="'manager_'+#id")
	@Cacheable(value="Manager",key="#id")
	public Manager findById(int id) {
		Manager manager=managerMapper.selectByPrimaryKey(id);
		return manager;
	}
	
	@Override
	//@CachePut(value="Manager",key="'manager_'+#manager.getId()")
	@CacheEvict(value="Manager",key="#manager.getId()" )
	//CacheEvict主要针对方法配置，能够根据一定的条件对缓存进行清空
	public void update(Manager manager) {
		managerMapper.updateByPrimaryKeySelective(manager);
	}*/
	
	

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


	//使用Redis缓存

	@Override
	//@Cacheable(value="Manager",key="#id.toString()")
	@Cacheable(value="Manager", keyGenerator = "keyGenerator")
	public Manager findById(String id) {
		System.out.println("--------");
		return managerMapper.selectByPrimaryKey(id);
	}

	@Override
	@CachePut(value="Manager",key="#root.caches[0].name + ':' + #manager.getId()")
	//#root.caches[0].name:当前被调用方法所使用的Cache, 即"Manager"
	//@CachePut(value="Manager", keyGenerator = "keyGenerator")
	//@CachePut指定了key属性之后，则不会再调用keygenerator的方法
	public Manager update(Manager manager) {
		
		managerMapper.updateByPrimaryKeySelective(manager);
		
		return managerMapper.selectByPrimaryKey(manager.getId());
	}
	
}
