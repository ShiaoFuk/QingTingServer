package com.example.qingtingserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayListMusic {
    private Integer id;

    /**
     * 音乐所属的歌单id
     */
    private Integer playListId;

    /**
     * 歌单的音乐id
     */
    private Integer musicId;
}