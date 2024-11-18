package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicMapper {
    @Select("select id, name, path, genre, tempo from music where name rlike #{name}")
    public List<Music> getMusic(String name);
}
