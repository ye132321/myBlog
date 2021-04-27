package com.blog.service.impl;

import com.blog.beans.Comment;
import com.blog.beans.Message;
import com.blog.dao.MessageDao;
import com.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    //存放子评论的集合
    private List<Message> tempReplys = new ArrayList<>();
    @Override
    public List<Message> listMessage() {
        //查出父节点
        List<Message> messages = messageDao.findByParentIdNull(Long.parseLong("-1"));
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            //查询出子留言
            List<Message> childMessages = messageDao.findByParentIdNotNull(id);
            combineChildren(childMessages,parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级留言
        if(childMessages.size() > 0){
            //循环找出子留言
            for(Message childMessage : childMessages){
                Long childId = childMessage.getId();
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                //查询二级留言
                recursively(childId,parentNickname);
            }
        }
    }

    private void recursively(Long childId, String parentNickname1) {
        List<Message> replayMessages = messageDao.findByReplayId(childId);
        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                recursively(replayId,parentNickname);
            }
        }
    }

    @Override
    public int saveMessage(Message message) {
        message.setCreateTime(new Date());
        return messageDao.saveMessage(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageDao.deleteMessage(id);
    }
}
