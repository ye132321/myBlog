package com.blog.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class Type {
    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<>();
}
