package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.PassToken;
import com.example.demo.annotation.UserLoginToken;
import com.example.demo.exception.SpringException;
import com.example.demo.handler.RequestThreadLocal;
import com.example.demo.models.User;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "鉴权登录相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    //登录
    @PassToken
    @PostMapping("/login")
    public Object login( User user){
        try {
            RequestThreadLocal.setAlarmRequestParam(JSONObject.toJSONString(user));
            JSONObject jsonObject=new JSONObject();
            User userForBase=userService.findByUsername(user);
            if(userForBase==null){
                throw new SpringException("用户不存在");
            }else {
                if (!userForBase.getPassword().equals(user.getPassword())){
                    jsonObject.put("message","登录失败,密码错误");
                    return jsonObject;
                }else {
                    String token = tokenService.getToken(userForBase);
                    jsonObject.put("token", token);
                    jsonObject.put("user", userForBase);
                    return jsonObject;
                }
            }
        }catch (Exception e){
            throw new SpringException("系统异常");
        }

    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @PassToken
    @GetMapping("/getMessage2")
    public String getMessage2(){
        return "你已通过验证";
    }
}
