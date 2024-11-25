package com.example.qingtingserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private Integer id;

    /**
     * 音乐名称
     */
    private String name;

    /**
     * 音乐时长
     */
    private Integer duration;

    /**
     * 音乐url
     */
    private String path;

    /**
     * 音乐类型
     */
    private String genre;

    /**
     * 演奏速度
     */
    private String tempo;
}