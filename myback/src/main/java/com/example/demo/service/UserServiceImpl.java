package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
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
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;


    public User getUser(String username, String password) {
        return userMapper.getUser(username, password);
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


    public int updateUserbackground(String userbackground, int id) {
        return userMapper.updateUserbackground(userbackground, id);
    }

    public int updateUserStyle(int userstyle, int id) {
        return userMapper.updateUserStyle(userstyle,id);
    }

    @Override
    public int addUser(String username, String password) {
        return userMapper.addUser(username,password);
    }
}
