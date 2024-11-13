package com.example.demo.service;


import com.example.demo.dao.ClassifyMapper;
import com.example.demo.pojo.Classify;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ClassifyServiceImpl implements ClassifyService{

    @Autowired
    ClassifyMapper classifyMapper;


    public List<Classify> getAllClassify() {
        return classifyMapper.getAllClassify();
    }

    public int addClassify(String name) {
        return classifyMapper.addClassify(name);
    }

    public Classify haveClassify(String name) {
        return classifyMapper.haveClassify(name);
    }

    public int deleteClassify(String name) {
        return classifyMapper.deleteClassify(name);
    }
}
