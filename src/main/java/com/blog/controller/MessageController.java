package com.blog.controller;

import com.blog.beans.Message;
import com.blog.beans.User;
import com.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Value("${comment.avatar}")
    private String avatar;
    @GetMapping("/message")
    public String message(){
        return "message";
    }
    //查询留言
    @GetMapping("/messagecomment")
    public String queryMessage(Model model){
        List<Message> messages = messageService.listMessage();
        model.addAttribute("messages",messages);
        return "message :: messageList";
    }
    //新增留言
    @PostMapping("/addMessage")
    public String addMessage(Model model, Message message, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        }else {
            message.setAvatar(avatar);
        }
        if(message.getParentMessage().getId() != null){
            message.setParentMessageId(message.getParentMessage().getId());
        }
        messageService.saveMessage(message);
        List<Message> messages = messageService.listMessage();
        model.addAttribute("messages",messages);
        return "message :: messageList";
    }
    //删除留言
    @GetMapping("/messages/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        messageService.deleteMessage(id);
        return "redirect:/message";
    }
}
