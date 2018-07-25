package com.zhangxf.dingcan.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import com.zhangxf.dingcan.common.base.BaseMapper;
import com.zhangxf.dingcan.pojo.TestUser;

@CacheNamespace
@Mapper
public interface TestUserMapper extends BaseMapper<TestUser>{
    int deleteByPrimaryKey(Integer id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);
}