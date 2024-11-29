package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);

    @Select("select id, name, path, genre, tempo from music where name rlike #{name}")
    List<Music> getMusic(String name);

    
}