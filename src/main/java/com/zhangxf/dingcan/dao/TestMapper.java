package com.zhangxf.dingcan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhangxf.dingcan.common.tkmapper.TkMapper;
import com.zhangxf.dingcan.pojo.Test;
@Mapper
public interface TestMapper extends TkMapper<Test>{
   /* int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);*/
    
    List<Test> getList();
}