package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}