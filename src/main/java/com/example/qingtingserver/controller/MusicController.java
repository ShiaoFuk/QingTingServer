package com.example.qingtingserver.controller;

import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.Result;
import com.example.qingtingserver.service.MusicService;
import com.example.qingtingserver.utils.AESCyperUtils;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {
    MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/music")
    public Result getMusic(String name) throws Exception {
        List<Music> musicList = musicService.getMusic(name);
        return Result.success(musicList);
    }
}
