package com.example.qingtingserver.controller;

import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.Result;
import com.example.qingtingserver.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {
    @Autowired
    MusicService musicService;

    @GetMapping("/music")
    public Result getMusic(String name) {
        List<Music> musicList = musicService.getMusic(name);
        return Result.success(musicList);
    }
}
