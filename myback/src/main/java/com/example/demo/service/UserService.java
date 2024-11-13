package com.example.demo.service;

import com.example.demo.pojo.User;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUser(@Param("username") String username, @Param("password") String password);

    User getUserById(@Param("id") int id);

    User getUserByUsername(@Param("username") String username);
    int updateUserbackground(@Param("userbackground") String userbackground, @Param("id") int id);
    int updateUserStyle(@Param("userstyle") int userstyle, @Param("id") int id);


    int addUser(@Param("username") String username, @Param("password") String password);

}
