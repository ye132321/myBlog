package com.blog.controller;

import com.blog.beans.Type;
import com.blog.queryvo.FirstPageBlog;
import com.blog.service.BlogService;
import com.blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    @GetMapping("/types/{id}")
    public String typeList(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                           @PathVariable("id") Long id, Model model){
        List<Type> types = typeService.getAllTypeAndBlog();
        model.addAttribute("types",types);
        if(id == -1){
            id = types.get(0).getId();
        }
        List<FirstPageBlog> blogList = blogService.getByTypeId(id);
        PageHelper.startPage(pageNum,10000);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
