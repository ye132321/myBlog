package com.blog.dao;

import com.blog.beans.FriendLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendLinkDao {
    List<FriendLink> listFriendLink();

    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLink(Long id);

    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);
}
