package com.example.demo.service;

import com.example.demo.pojo.Liuyan;
import com.example.demo.pojo.LiuyanVO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface LiuyanService {
    List<Liuyan> getLiuyan();

    //添加留言
    int addLiuyan(String username, String content, Date time);

    LiuyanVO transform(Liuyan liuyan);
}
