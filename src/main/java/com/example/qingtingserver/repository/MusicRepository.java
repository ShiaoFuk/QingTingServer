package com.example.qingtingserver.repository;

import com.example.qingtingserver.dao.MusicMapper;
import com.example.qingtingserver.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {

    MusicMapper musicMapper;
    @Autowired
    public MusicRepository(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    public List<Music> getMusic(String searchWord) {
        return musicMapper.getMusic(searchWord);
    }
}
