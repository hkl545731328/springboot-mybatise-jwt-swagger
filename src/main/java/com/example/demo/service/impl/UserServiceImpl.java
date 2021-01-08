package com.example.demo.service.impl;

import com.example.demo.mappers.UserMapper;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(User user){
        return userMapper.findByUsername(user.getUsername());
    }

    @Override
    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }
}
