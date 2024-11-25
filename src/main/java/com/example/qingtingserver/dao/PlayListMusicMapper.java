package com.example.qingtingserver.dao;

import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.PlayListMusic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface PlayListMusicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlayListMusic record);

    int insertSelective(PlayListMusic record);

    PlayListMusic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlayListMusic record);

    int updateByPrimaryKey(PlayListMusic record);

    int insertList(@Param("play_list_id") Integer playListId, @Param("list") List<Integer> list);

    List<Music> selectMusicListById(@Param("play_list_id") Integer playListId);

    /**
     * 删除歌单中某一首音乐
     *
     * @param playListId
     * @param musicId
     * @return
     */
    int deleteByPlayListIdAndMusicId(@Param("playListId") Integer playListId, @Param("musicId") Integer musicId);

    /**
     * 批量删除歌单的音乐
     *
     * @param playListId
     * @param musicIdCollection
     * @return
     */
    int deleteByPlayListIdAndMusicIdIn(@Param("playListId") Integer playListId, @Param("musicIdCollection") Collection<Integer> musicIdCollection);

    /**
     * 根据歌单id删除歌单，用于联合删除和清空歌单
     *
     * @param playListId
     * @return
     */
    int deleteByPlayListId(@Param("playListId") Integer playListId);
}