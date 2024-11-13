package com.example.demo.dao;


import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {
     //根据username和password返回一个user
     User getUser(@Param("username") String username, @Param("password") String password);


     //根据ID返回用户
     User getUserById(@Param("id") int id);

     User getUserByUsername(@Param("username") String username);

     //改变用户的userbackground的地址
     int updateUserbackground(@Param("userbackground") String userbackground, @Param("id") int id);


     //更改用户背景图风格
     int updateUserStyle(@Param("userstyle") int userstyle, @Param("id") int id);

     int addUser(@Param("username") String username, @Param("password") String password);


}
