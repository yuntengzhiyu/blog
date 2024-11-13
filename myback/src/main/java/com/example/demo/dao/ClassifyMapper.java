package com.example.demo.dao;


import com.example.demo.pojo.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ClassifyMapper {
    List<Classify> getAllClassify();


    //根据String name添加分类
    int addClassify(@Param("name") String name);


    //根据String name判断是否有这个分类
    Classify haveClassify(@Param("name") String name);

    //根据String name删除分类
    int deleteClassify(@Param("name") String name);
}
