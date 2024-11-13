package com.example.demo.service;

import com.example.demo.dao.FriendLinkMapper;
import com.example.demo.dao.LiuyanMapper;
import com.example.demo.pojo.Liuyan;
import com.example.demo.pojo.LiuyanVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class LiuyanServiceImpl implements LiuyanService{

    @Autowired
    LiuyanMapper liuyanMapper;


    public List<Liuyan> getLiuyan() {
        return liuyanMapper.getLiuyan();
    }

    public int addLiuyan(String username, String content, Date time) {
        return liuyanMapper.addLiuyan(username,content,time);
    }

    public LiuyanVO transform(Liuyan liuyan) {
        LiuyanVO liuyanVO = new LiuyanVO();
        liuyanVO.setLiuyanid(liuyan.getLiuyanid());
        liuyanVO.setUsername(liuyan.getUsername());
        liuyanVO.setContent(liuyan.getContent());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(liuyan.getTime());
        liuyanVO.setTime(s);
        return liuyanVO;
    }


}
