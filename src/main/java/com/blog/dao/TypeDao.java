package com.blog.dao;

import com.blog.beans.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TypeDao {
    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);
}
