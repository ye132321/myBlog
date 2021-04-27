package com.blog.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RecommendBlog {
    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;
}
