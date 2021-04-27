package com.blog.service;

import com.blog.beans.Message;

import java.util.List;

public interface MessageService {
    //查询所有留言
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);
}
