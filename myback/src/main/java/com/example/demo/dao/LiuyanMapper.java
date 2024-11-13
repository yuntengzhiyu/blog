package com.example.demo.dao;

import com.example.demo.pojo.Liuyan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface LiuyanMapper {

    //查询所有的留言
    List<Liuyan> getLiuyan();

    //添加留言
    int addLiuyan(@Param("username") String username,@Param("content") String content,@Param("time") Date time);

}
