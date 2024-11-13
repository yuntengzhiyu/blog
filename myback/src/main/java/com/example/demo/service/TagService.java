package com.example.demo.service;

import com.example.demo.pojo.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TagService {
    Tag haveTag(@Param("name") String name);

    int addTag(@Param("name") String name);
    List<Tag> getAllTags();


    int deleteTag(@Param("name") String name);
}
