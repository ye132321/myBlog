package com.blog.controller;

import com.blog.beans.Picture;
import com.blog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PictureShowController {
    @Autowired
    private PictureService pictureService;
    @GetMapping("/picture")
    public String picture(Model model){
        List<Picture> pictures = pictureService.listPicture();
        model.addAttribute("pictures",pictures);
        return "picture";
    }
}
