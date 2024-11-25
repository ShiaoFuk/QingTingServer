package com.example.qingtingserver.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.qingtingserver.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);


    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllByUsername(@Param("username")String username);

    int insertSelective(User user);




}