package com.example.qingtingserver.service;

import com.example.qingtingserver.dao.MusicMapper;
import com.example.qingtingserver.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    MusicMapper musicMapper;
    public List<Music> getMusic(String searchName) {
        return musicMapper.getMusic(searchName);
    }
}
