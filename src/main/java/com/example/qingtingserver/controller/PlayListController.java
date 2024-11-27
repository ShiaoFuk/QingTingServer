package com.example.qingtingserver.controller;

import com.example.qingtingserver.model.Music;
import com.example.qingtingserver.model.Result;
import com.example.qingtingserver.service.PlayListService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playList")
public class PlayListController {
    PlayListService playListService;
    @Autowired
    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    private final static String NO_RECORDS = "no record modified";
    private final static String VERIFY_FALSE = "verify false";

    /**
     * 添加一个歌单
     * @param token
     * @param name 歌单名称
     * @return id
     */
    @PutMapping("/add")
    public Result addPlayList(@NonNull @Validated @RequestParam String token, @NonNull @Validated @RequestParam String name) {
        Integer id = playListService.addPlayList(token, name);
        if (id != null) {
            return Result.success(id);
        }
        return Result.errorMessage(NO_RECORDS);
    }

    /**
     * 删除一个歌单
     * @param token
     * @param playListId 歌单id
     * @return 删除的条数
     */
    @DeleteMapping("/delete")
    public Result deletePlayList(@NonNull @Validated @RequestParam String token, @NonNull @Validated @RequestParam Integer playListId) {
        Integer num = playListService.deletePlayList(token, playListId);
        if (num == null) { return Result.errorMessage(NO_RECORDS); }
        if (num > 0) {
            return Result.success();
        }
        return Result.errorMessage(NO_RECORDS);
    }

    /**
     * 更新歌单，比如歌单名称
     * @param token
     * @param name 新的歌单名称
     * @return 更新的条数
     */
    @PutMapping("/update")
    public Result updatePlayList(@NonNull @Validated @RequestParam String token, @NonNull @Validated @RequestParam Integer playListId, @NonNull @Validated @RequestParam String name) {
        int num = playListService.updatePlayList(token, playListId, name);
        if (num > 0) {
            return Result.success();
        }
        return Result.errorMessage(NO_RECORDS);
    }

    /**
     * 查询用户所有歌单
     * @param token
     * @return 用户所有歌单
     */
    @GetMapping("/get")
    public Result getPlayListById(@NonNull @Validated @RequestParam String token) {
        return Result.success(playListService.getPlayListById(token));
    }


    /**
     * 向歌单添加多首歌
     * @param playListId
     * @param musicList 音乐列表
     * @return
     */
    @PutMapping("/song/addMany")
    public Result addMusicToPlayList(@NonNull @Validated @RequestParam String token,
                                     @NonNull @Validated @RequestParam Integer playListId,
                                     @NonNull @Validated @RequestParam List<Integer> musicList) {
        Integer num = playListService.addMusicToPlayList(token, playListId, musicList);
        if (num == null) {
            return Result.errorMessage(NO_RECORDS);
        }
        if (num > 0) {
            return Result.success();
        }
        return Result.errorMessage(NO_RECORDS);
    }

    /**
     * 从歌单删除一首歌
     * @param playListId
     * @param musicId 音乐id
     * @return
     */
    @DeleteMapping("/song/deleteOne")
    public Result deleteMusicFromPlayList(@NonNull @Validated @RequestParam String token, @NonNull @Validated @RequestParam Integer playListId, @NonNull @Validated @RequestParam Integer musicId) {
        Integer num = playListService.deleteMusicFromPlayList(token, playListId, musicId);
        if (num == null) {
            return Result.errorMessage(NO_RECORDS);
        }
        if (num > 0) {
            return Result.success();
        }
        return Result.errorMessage(NO_RECORDS);
    }

    /**
     * 从歌单删除多首歌
     * @param playListId
     * @param musicIdList
     * @return
     */
    @DeleteMapping("/song/deleteMany")
    public Result deleteMusicsFromPlayList(@NonNull @Validated @RequestParam String token, @NonNull @Validated @RequestParam Integer playListId, @NonNull @Validated @RequestParam List<Integer> musicIdList) {
        Integer num = playListService.deleteMusicsFromPlayList(token, playListId, musicIdList);
        if (num == null) {
            return Result.errorMessage(NO_RECORDS);
        }
        if (num > 0) {
            return Result.success();
        }
        return Result.errorMessage(NO_RECORDS);
    }

    /**
     * 从歌单获取所有歌
     * @param playListId
     * @return
     */
    @GetMapping("song/get")
    public Result getMusicFromPlayList(@NonNull @Validated @RequestParam String token, @NonNull @Validated @RequestParam Integer playListId) {
        List<Music> musicList = playListService.getMusicFromPlayList(token, playListId);
        if (musicList == null) {
            return Result.errorMessage(VERIFY_FALSE);
        }
        return Result.success(musicList);
    }
}
