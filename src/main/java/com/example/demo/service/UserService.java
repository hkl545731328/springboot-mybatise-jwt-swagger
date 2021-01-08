package com.example.demo.service;

import com.example.demo.models.User;

public interface UserService {

    public User findByUsername(User user);

    public User findUserById(String userId);

}
