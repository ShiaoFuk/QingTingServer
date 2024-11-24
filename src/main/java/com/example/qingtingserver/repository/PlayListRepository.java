package com.example.qingtingserver.repository;

import com.example.qingtingserver.dao.PlayListMapper;
import com.example.qingtingserver.dao.PlayListMusicMapper;
import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.PlayList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayListRepository {
    PlayListMapper playListMapper;
    PlayListMusicMapper playListMusicMapper;

    public PlayListRepository(PlayListMapper playListMapper, PlayListMusicMapper playListMusicMapper) {
        this.playListMapper = playListMapper;
        this.playListMusicMapper = playListMusicMapper;
    }

    // 增加一个歌单
    public Integer addPlayList(PlayList playList) {
        return playListMapper.insertSelective(playList);
    }

    // 删除一个歌单
    public Integer deletePlayList(int playListId) {
        return playListMapper.deleteByPrimaryKey(playListId) + playListMusicMapper.deleteByPrimaryKey(playListId);
    }

    // 改动
    public Integer updatePlayList(PlayList playList) {
        return playListMapper.updateByPrimaryKeySelective(playList);
    }

    // 查询用户所有歌单
    public List<PlayList> getPlayListById(Integer userId) {
        return playListMapper.findPlayListByUserId(userId);
    }


    // 添加歌到歌单
    public Integer addMusicToPlayList(int playListId, List<Integer> musicList) {
        return playListMusicMapper.insertList(playListId, musicList);
    }

    // 删除歌从歌单
    public Integer deleteMusicFromPlayList(int playListId, int musicId) {
        return playListMusicMapper.deleteByPlayListIdAndMusicId(playListId, musicId);
    }


    public Integer deleteMusicsFromPlayList(int playListId, List<Integer> musicIdList) {
        return playListMusicMapper.deleteByPlayListIdAndMusicIdIn(playListId, musicIdList);
    }

    // 获取歌单中的所有值
    public List<Music> getMusicFromPlayList(int playListId) {
        return playListMusicMapper.selectMusicListById(playListId);
    }

}
