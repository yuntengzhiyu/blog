package com.example.demo.controller;


import com.example.demo.pojo.Classify;
import com.example.demo.service.ClassifyService;
import com.example.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@CrossOrigin
public class ClassifyController {

    @Autowired
    ClassifyService classifyService;

    @RequestMapping("getAllClassify")
    public ServerResponse getAllClassify(){
        List<Classify> list = classifyService.getAllClassify();
        return ServerResponse.createBySuccess("成功获取数据",list);
    }
}
