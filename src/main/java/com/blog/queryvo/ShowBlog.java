package com.blog.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@ToString
public class ShowBlog {
    private Long id;
    //标题
    private String title;
    //评论内容
    private String content;
    //首图
    private String firstPicture;
    //标记
    private String flag;
    //赞赏开启
    private boolean appreciation;
    //转载声明
    private boolean shareStatement;
    //是否可评论
    private boolean commentabled;
    //版权开启
    private boolean published;
    //是否推荐
    private boolean recommend;
    //更新评论时间
    private Date updateTime;
    private String description;
    private Long typeId;
}
