package com.example.demo.dao;

import com.example.demo.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TagMapper {

    //判断是否有这个Tag
    Tag haveTag(@Param("name") String name);


    //根据name添加这个Tag
    int addTag(@Param("name") String name);

    //得到所有的标签
    List<Tag> getAllTags();


    //根据name删除Tag
    int deleteTag(@Param("name") String name);



}
