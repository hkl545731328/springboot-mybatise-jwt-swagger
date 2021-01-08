package com.example.demo.service;

import com.example.demo.models.User;

public interface TokenService {
    public String getToken(User user);
}
