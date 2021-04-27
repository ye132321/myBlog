package com.blog.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class SearchBlog {
    private String title;
    private Long typeId;
}
