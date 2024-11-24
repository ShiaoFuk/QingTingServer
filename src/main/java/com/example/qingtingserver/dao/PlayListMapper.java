package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.PlayList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayListMapper {

    @Select("select * from music where id in " +
            "(select music_id from play_list l, play_list_music m where l.id = m.play_list_id)")
    List<Music> getMusicInPlayList(PlayList playList);

}