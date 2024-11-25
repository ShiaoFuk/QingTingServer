package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginRegisterMapper {

    @Insert("insert into user(username, password) value (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void registerUser(User user);



    @Select("select * from user where username = #{username}")
    public User loginUser(User user);
}
