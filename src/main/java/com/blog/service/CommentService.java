package com.blog.service;

import com.blog.beans.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

    void deleteComment(Comment comment,Long id);
}
