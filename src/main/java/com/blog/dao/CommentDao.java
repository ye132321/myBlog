package com.blog.dao;

import com.blog.beans.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CommentDao {
    //根据创建时间倒序来排序评论
    List<Comment> findByBlogIdAndParentIdNull(@Param("blogId") Long blogId, @Param("parentCommentId") Long parentCommentId);

    //查询一级回复
    List<Comment> findByBlogIdAndParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);

    //查询二级回复
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId,@Param("childId") Long childId);

    //添加一个评论
    int saveComment(Comment comment);

    //删除评论
    void deleteComment(Long id);
}
