package com.blog.beans;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class User {
    private Long id;
    private String avatar;
    private Date createTime;
    private String email;
    private String nickname;
    private String password;
    private Integer type;
    private Date updateTime;
    private String username;
}
