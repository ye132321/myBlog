package com.blog.service;

import com.blog.beans.Picture;

import java.util.List;

public interface PictureService {
    List<Picture> listPicture();

    int savePicture(Picture picture);

    Picture getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}
