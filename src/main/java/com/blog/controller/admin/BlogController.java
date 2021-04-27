package com.blog.controller.admin;

import com.blog.beans.Blog;
import com.blog.beans.Type;
import com.blog.beans.User;
import com.blog.queryvo.BlogQuery;
import com.blog.queryvo.SearchBlog;
import com.blog.queryvo.ShowBlog;
import com.blog.service.BlogService;
import com.blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    //博客列表
    @GetMapping("/blogs")
    public String listBlogs(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<BlogQuery> blogQueryList = blogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueryList);
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }
    //跳转博客新增页面
    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("blog",new Blog());
        return "admin/blogs-input";
    }
    //新增博客
    @PostMapping("/blogs")
    public String addBlog(Blog blog, RedirectAttributes attributes, HttpSession session){
//        blog.setUser((User) session.getAttribute("user"));
//        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setUserId(((User) session.getAttribute("user")).getId());
        blog.setTypeId(blog.getType().getId());
        int i = blogService.saveBlog(blog);
        if(i == 0){
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/blogs";
    }
    //删除文章
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable("id") Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }
    //跳转到编辑修改文章页面
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable("id") Long id,Model model){
        ShowBlog showBlog = blogService.getBlogById(id);
        List<Type> typeList = typeService.getAllType();
        model.addAttribute("blog",showBlog);
        model.addAttribute("types",typeList);
        return "admin/blogs-input";
    }

    //编辑修改文章
    @PostMapping("/blogs/{id}")
    public String updateBlog(ShowBlog showBlog,RedirectAttributes attributes){
        int i = blogService.updateBlog(showBlog);
        if(i == 0){
            attributes.addFlashAttribute("message","修改失败");
        }else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/blogs";
    }
    //搜索博客
    @PostMapping("/blogs/search")
    public String search(SearchBlog searchBlog,Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
        PageHelper.startPage(pageNum,10);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs :: blogList";
    }
}
