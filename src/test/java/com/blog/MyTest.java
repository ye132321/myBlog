package com.blog;

import com.blog.beans.Comment;
import com.blog.beans.Message;
import com.blog.dao.BlogDao;
import com.blog.dao.CommentDao;
import com.blog.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBlogApplication.class)
public class MyTest {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private MessageService messageService;
    @Test
    public void test01(){
        Comment comment = new Comment();
        comment.setNickname("晴天");
        comment.setEmail("123456@qq.com");
        comment.setContent("很好");
        comment.setAvatar("123");
        comment.setCreateTime(new Date());
        comment.setBlogId((long) 101);
        comment.setParentCommentId((long) 102);
        comment.setAdminComment(false);

        int i = commentDao.saveComment(comment);
        System.out.println("增加的记录数为" + i);
    }

    @Test
    public void test02(){
        List<Comment> byBlogIdAndParentIdNotNull = commentDao.findByBlogIdAndParentIdNotNull((long) 101, (long) 102);
        System.out.println(byBlogIdAndParentIdNotNull);
    }

    @Test
    public void test03(){
        commentDao.deleteComment((long)29);
    }

    @Test
    public void test04(){
        System.out.println(blogDao.getBlogById((long)64).toString());
    }
    @Test
    public void test05(){
//        messageService.saveMessage(new Message("5","12345@qq.com","hello222","123",new Date(),Long.parseLong("-1"),false));
    }
    @Test
    public void test06(){
        messageService.deleteMessage(Long.parseLong("106"));
    }
    @Test
    public void test07(){
        List<Message> messages = messageService.listMessage();
        for(Message message : messages){
            System.out.println(message);
        }
    }
}
