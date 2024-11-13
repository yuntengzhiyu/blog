package com.example.demo.controller;


import com.example.demo.pojo.FriendLink;
import com.example.demo.pojo.FriendLinkVO;
import com.example.demo.service.FriendLinkService;
import com.example.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@CrossOrigin
public class FriendLinkController {

    @Autowired
    FriendLinkService friendLinkService;



    //添加友链
    @RequestMapping(value="addFriend",method = RequestMethod.POST)
    public ServerResponse addFriend(@RequestBody Map<String,Object> map){
        String name = map.get("name").toString();
        String url = map.get("url").toString();
        Date date = new Date();
        int num = friendLinkService.addFriend(name, url, date);
        if(num > 0){
            return ServerResponse.createBySuccess("成功添加",null);
        }
        else return ServerResponse.createByError("添加失败");

    }
    @RequestMapping("getFriend")
    public ServerResponse getFriend(){
        List<FriendLink> list = friendLinkService.getFriend();

        List<FriendLinkVO> list2 = new LinkedList<FriendLinkVO>();
        for(FriendLink friendLink: list){
            FriendLinkVO friendLinkVO = friendLinkService.transformFriendLink(friendLink);
            friendLinkVO.setTime(friendLinkVO.getTime().substring(0,10));
            list2.add(friendLinkVO);
        }
        return ServerResponse.createBySuccess("数据成功",list2);
    }

    @RequestMapping(value = "updateFriend", method = RequestMethod.POST)
    public ServerResponse updateFriend(@RequestBody Map<String, Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        String name = map.get("name").toString();
        String url = map.get("url").toString();

        System.out.println(id);
        System.out.println(name);
        int num = friendLinkService.updateFriend(id, name, url);
        if(num > 0){
            return ServerResponse.createBySuccess("添加友链成功",null);
        }
        else return ServerResponse.createByError("添加友链失败");
    }


    @RequestMapping("deleteFriend")
    public ServerResponse deleteFriend(@RequestParam("id") int id){
        int num = friendLinkService.deleteFriend(id);
        if(num > 0){
            return ServerResponse.createBySuccess("成功删除",null);
        }
        else return ServerResponse.createByError("删除失败");
    }
}
