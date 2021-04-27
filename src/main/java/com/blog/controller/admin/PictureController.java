package com.blog.controller.admin;

import com.blog.beans.Picture;
import com.blog.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    //分页展示所有图片
    @GetMapping("/pictures")
    public String pictures(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Picture> listPicture = pictureService.listPicture();
        PageInfo<Picture> pageInfo = new PageInfo<>(listPicture);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }
    //跳转到新增图片页面
    @GetMapping("/pictures/input")
    public String input(Model model){
        model.addAttribute("picture",new Picture());
        return "admin/pictures-input";
    }
    //保存图片
    @PostMapping("/pictures")
    public String addPicture(Picture picture, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "admin/pictures-input";
        }
        int p = pictureService.savePicture(picture);
        if(p == 0){
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/pictures";
    }
    //跳转编辑图片页面
    @GetMapping("/pictures/{id}/input")
    public String editInput(@PathVariable("id") Long id,Model model){
        model.addAttribute("picture",pictureService.getPicture(id));
        return "admin/pictures-input";
    }

    @PostMapping("/pictures/{id}")
    public String editPicture(Picture picture,RedirectAttributes attributes){
        int p = pictureService.updatePicture(picture);
        if(p == 0){
            attributes.addFlashAttribute("message","编辑失败");
        }else {
            attributes.addFlashAttribute("message","编辑成功");
        }
        return "redirect:/admin/pictures";
    }

    //删除图片
    @GetMapping("/pictures/{id}/delete")
    public String delete(@PathVariable("id") Long id,RedirectAttributes attributes){
        pictureService.deletePicture(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/pictures";
    }
}
