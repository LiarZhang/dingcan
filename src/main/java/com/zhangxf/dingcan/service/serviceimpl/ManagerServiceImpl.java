package com.zhangxf.dingcan.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	
}
