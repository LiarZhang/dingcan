package com.zhangxf.dingcan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zhangxf.dingcan.common.tkmapper.TkMapper;
import com.zhangxf.dingcan.pojo.Manager;
@Mapper
public interface ManagerMapper extends TkMapper<Manager> {
   /* int deleteByPrimaryKey(String id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);*/
}