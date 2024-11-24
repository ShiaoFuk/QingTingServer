package com.example.qingtingserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayList {
    Integer id;
    Integer userId;
    String name;
    Integer likes;
    Date createdTime;
    Date updatedTime;
}
