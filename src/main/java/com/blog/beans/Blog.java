package com.blog.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@ToString
public class Blog {
    private Long id;
    //标题
    private String title;
    //评论内容
    private String content;
    //首图
    private String firstPicture;
    //标记
    private String flag;
    //浏览次数
    private Integer views;
    //评论次数
    private Integer commentCount;
    //赞赏开启
    private boolean appreciation;
    //是否发布
    private boolean shareStatement;
    //是否可评论
    private boolean commentabled;
    //版权开启
    private boolean published;
    //是否推荐
    private boolean recommend;
    //创建评论时间
    private Date createTime;
    //更新评论时间
    private Date updateTime;

    private Long typeId;
    private Long userId;
    private String description;
    private Type type;
    private User user;
    private List<Comment> comments = new ArrayList<>();
}
