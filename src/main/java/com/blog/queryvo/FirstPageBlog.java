package com.blog.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@ToString
public class FirstPageBlog {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;
    //Type
    private String typeName;
    //User
    private String nickname;
    private String avatar;
}
