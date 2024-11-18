package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicMapper {
    @Select("select * from music where name name rlike #{name}")
    public List<Music> getMusic(String name);
}
