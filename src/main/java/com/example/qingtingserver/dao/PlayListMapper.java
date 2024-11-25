package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.PlayList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlayListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlayList record);

    int insertSelective(PlayList record);

    PlayList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlayList record);

    int updateByPrimaryKey(PlayList record);

    /**
     * 根据PlayList的id查询对应的所有音乐
     *
     * @param playListId
     * @return 音乐列表
     */
    List<Music> findMusicInPlayList(@Param("id") Integer playListId);

    /**
     * 获取用户所有播放列表
     *
     * @param userId
     * @return
     */
    List<PlayList> findPlayListByUserId(@Param("id") Integer userId);



}