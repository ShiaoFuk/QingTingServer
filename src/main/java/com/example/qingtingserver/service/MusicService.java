package com.example.qingtingserver.service;

import com.example.qingtingserver.dao.MusicMapper;
import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRespository) {
        this.musicRepository = musicRespository;
    }

    public List<Music> getMusic(String searchName) {
        return musicRepository.getMusic(searchName);
    }
}
