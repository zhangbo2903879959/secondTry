package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/userpage",method = RequestMethod.GET)
    public List<User> query(){
        return userMapper.selectList(null);
    }

    @RequestMapping(value = "/userpage/adduser",method = RequestMethod.POST)
    public String adduser(@RequestBody User user){// 自动把 dto 的 name/email 复制到 user
        userMapper.insert(user);
        return "用户创建成功，ID: " + user.getId(); // MP 会自动回填自增 ID
    }


}
