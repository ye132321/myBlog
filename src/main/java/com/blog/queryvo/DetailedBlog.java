package com.blog.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@ToString
public class DetailedBlog {
    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;
    //Type
    private String typeName;
}
