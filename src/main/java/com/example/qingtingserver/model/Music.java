package com.example.qingtingserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.JavaBean;
import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Music {
    Integer id;
    String name;
    Integer duration;
    String path;
    String genre;
    String tempo;
    Date createdTime;
    Date updatedTime;
}
