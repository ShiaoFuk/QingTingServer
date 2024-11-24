package com.example.qingtingserver.service;

import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.PlayList;
import com.example.qingtingserver.repository.PlayListRepository;
import com.example.qingtingserver.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {
    PlayListRepository playListRepository;
    JwtUtil jwtUtil;
    public PlayListService(PlayListRepository playListRepository, JwtUtil jwtUtil) {
        this.playListRepository = playListRepository;
        this.jwtUtil = jwtUtil;
    }

    // 增加一个歌单
    public Integer addPlayList(String token, String name) {
        PlayList playList = new PlayList();
        Integer userId = jwtUtil.verifyToken(token);
        playList.setUserId(userId);
        playList.setName(name);
        return playListRepository.addPlayList(playList);
    }

    // 删除一个歌单
    public Integer deletePlayList(String token, int playListId) {
        Integer userId = jwtUtil.verifyToken(token);
        if (userId == null) {return null; }
        return playListRepository.deletePlayList(playListId);
    }

    // 改动
    public Integer updatePlayList(String token, Integer playListId, String name) {
        PlayList playList = new PlayList();
        Integer userId = jwtUtil.verifyToken(token);
        playList.setUserId(userId);
        playList.setName(name);
        playList.setId(playListId);
        return playListRepository.updatePlayList(playList);
    }

    // 查询用户所有歌单
    public List<PlayList> getPlayListById(String token) {
        Integer userId = jwtUtil.verifyToken(token);
        return playListRepository.getPlayListById(userId);
    }


    // 添加歌到歌单
    public Integer addMusicToPlayList(String token, int playListId, List<Integer> musicList) {
        if (jwtUtil.verifyToken(token) == null) return null;
        return playListRepository.addMusicToPlayList(playListId, musicList);
    }

    // 删除歌从歌单
    public Integer deleteMusicFromPlayList(String token, int playListId, int musicId) {
        if (jwtUtil.verifyToken(token) == null) return null;
        return playListRepository.deleteMusicFromPlayList(playListId, musicId);
    }


    public Integer deleteMusicsFromPlayList(String token, int playListId, List<Integer> musicIdList) {
        if (jwtUtil.verifyToken(token) == null) return null;
        return playListRepository.deleteMusicsFromPlayList(playListId, musicIdList);
    }

    public List<Music> getMusicFromPlayList(String token, Integer playListId) {
        if (jwtUtil.verifyToken(token) == null) return null;
        return playListRepository.getMusicFromPlayList(playListId);
    }
}
