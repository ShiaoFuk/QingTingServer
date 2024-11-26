package com.example.qingtingserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayList {
    private Integer id;

    /**
     * 歌单所属用户id
     */
    private Integer userId;

    /**
     * 歌单名称
     */
    private String name;

    /**
     * 点赞次数
     */
    private Integer likes;

    private Integer playTimes;

    /**
     * 头像url
     */
    private String url;

}