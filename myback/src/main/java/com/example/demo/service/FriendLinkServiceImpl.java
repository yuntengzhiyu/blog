package com.example.demo.service;

import com.example.demo.dao.FriendLinkMapper;
import com.example.demo.pojo.FriendLink;
import com.example.demo.pojo.FriendLinkVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class FriendLinkServiceImpl implements FriendLinkService{

    @Autowired
    FriendLinkMapper friendLinkMapper;


    public List<FriendLink> getFriend() {
        return friendLinkMapper.getFriend();
    }

    public FriendLinkVO transformFriendLink(FriendLink friendLink) {
        FriendLinkVO friendLinkVO = new FriendLinkVO();
        friendLinkVO.setId(friendLink.getId());
        friendLinkVO.setName(friendLink.getName());
        friendLinkVO.setUrl(friendLink.getUrl());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(friendLink.getTime());
        friendLinkVO.setTime(s);
        return friendLinkVO;
    }

    public int updateFriend(int id, String name, String url) {
        return friendLinkMapper.updateFriend(id, name, url);
    }

    public int deleteFriend(int id) {
        return friendLinkMapper.deleteFriend(id);
    }

    public int addFriend(String name, String url, Date time) {
        return friendLinkMapper.addFriend(name, url, time);
    }
}
