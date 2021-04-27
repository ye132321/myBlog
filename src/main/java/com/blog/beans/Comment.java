package com.blog.beans;

import com.blog.queryvo.DetailedBlog;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@ToString
public class Comment {
    private Long id;
    //昵称
    private String nickname;
    //邮箱
    private String email;
    //评论内容
    private String content;
    //头像
    private String avatar;
    //创建时间
    private Date createTime;
    //博客id
    private Long blogId;
    //父评论id
    private Long parentCommentId;
    //父评论昵称
    private String parentNickname;
    //子评论
    private List<Comment> replyComments = new ArrayList<>();
    //父评论
    private Comment parentComment;
    //是否是管理员id
    private boolean adminComment;

    private DetailedBlog blog;
}
