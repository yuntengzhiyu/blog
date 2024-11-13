package com.example.demo.service;

import com.example.demo.pojo.Classify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClassifyService {
    List<Classify> getAllClassify();

    int addClassify(@Param("name") String name);

    Classify haveClassify(@Param("name") String name);

    int deleteClassify(@Param("name") String name);


}
