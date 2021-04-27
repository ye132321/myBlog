package com.blog.controller.admin;

import com.blog.beans.Type;
import com.blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;
    //分页展示分类列表
    @GetMapping("/types")
    public String listTypes(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 10);
        List<Type> typeList = typeService.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<>(typeList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }
    //跳转到新增分类页面
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }
    //新增分类
    @PostMapping("/types")
    public String addType(Type type, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/types/input";
        }else {
            int i = typeService.saveType(type);
            attributes.addFlashAttribute("message","新增成功");
            return "redirect:/admin/types";
        }
        /*int i = typeService.saveType(type);
        if(i == 0){
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";*/
    }
    //跳转修改分类页面
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable("id") Long id,Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }
    //删除分类
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable("id") Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
    //更改分类
    @PostMapping("/types/{id}")
    public String update(Type type,RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/types/input";
        }else {
            int i = typeService.updateType(type);
            attributes.addFlashAttribute("message","编辑成功");
            return "redirect:/admin/types";
        }
    }
}
