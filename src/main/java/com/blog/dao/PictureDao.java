package com.blog.dao;

import com.blog.beans.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureDao {
    //查询所有图片
    List<Picture> listPicture();
    //保存图片
    int savePicture(Picture picture);
    //通过id获取图片
    Picture getPicture(Long id);
    //更新图片
    int updatePicture(Picture picture);
    //通过id删除图片
    void deletePicture(Long id);
}
