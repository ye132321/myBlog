package com.blog.controller;

import com.blog.queryvo.BlogQuery;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArchivesShowController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/archives")
    public String archives(Model model){
        List<BlogQuery> blogs = blogService.getAllBlog();
        model.addAttribute("blogs",blogs);
        return "archives";
    }
}
