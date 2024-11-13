package com.example.demo.dao;

import com.example.demo.pojo.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface FriendLinkMapper {

    List<FriendLink> getFriend();

    //更改友链
    int updateFriend(@Param("id") int id, @Param("name") String name, @Param("url") String url);

    //根据id删除友链
    int deleteFriend(@Param("id") int id);


    //添加朋友
    int addFriend(@Param("name") String name, @Param("url") String url, @Param("time") Date time);
}
