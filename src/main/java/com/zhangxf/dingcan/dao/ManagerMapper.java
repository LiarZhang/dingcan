package com.zhangxf.dingcan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.zhangxf.dingcan.pojo.Manager;

@Mapper
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    
    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

   
    int updateByPrimaryKey(Manager record);
}