package com.example.demo.service;

import com.example.demo.dao.TagMapper;
import com.example.demo.pojo.Tag;
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
public class TagServiceImpl implements TagService{

    @Autowired
    TagMapper tagMapper;

    public Tag haveTag(String name) {
        return tagMapper.haveTag(name);
    }

    public int addTag(String name) {
        return tagMapper.addTag(name);
    }

    public List<Tag> getAllTags() {
        return tagMapper.getAllTags();
    }

    public int deleteTag(String name) {
        return tagMapper.deleteTag(name);
    }
}
