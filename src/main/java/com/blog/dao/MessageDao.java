package com.blog.dao;

import com.blog.beans.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageDao {
    //添加留言
    int saveMessage(Message message);

    //查询父级留言
    List<Message> findByParentIdNull(@Param("ParentId") Long ParentId);

    //查询一级回复
    List<Message> findByParentIdNotNull(@Param("id") Long id);

    //查询二级回复
    List<Message> findByReplayId(@Param("childId") Long childId);

    //删除留言
    void deleteMessage(Long id);
}
