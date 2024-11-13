package com.example.demo.service;

import com.example.demo.pojo.FriendLink;
import com.example.demo.pojo.FriendLinkVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface FriendLinkService {
    List<FriendLink> getFriend();

    FriendLinkVO transformFriendLink(FriendLink friendLink);

    int updateFriend(@Param("id") int id, @Param("name") String name, @Param("url") String url);

    int deleteFriend(@Param("id") int id);
    int addFriend(@Param("name") String name, @Param("url") String url, @Param("time") Date time);

}
