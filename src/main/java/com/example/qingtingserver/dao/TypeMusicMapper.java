package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.TypeMusic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMusicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypeMusic record);

    int insertSelective(TypeMusic record);

    TypeMusic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeMusic record);

    int updateByPrimaryKey(TypeMusic record);
}