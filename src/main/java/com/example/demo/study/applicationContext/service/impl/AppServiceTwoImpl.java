package com.example.demo.study.applicationContext.service.impl;

import com.example.demo.annotation.FileHandler;
import com.example.demo.enums.FileTypeEnum;
import com.example.demo.study.applicationContext.service.AppService;

@FileHandler(componentName = "appTwo",fileType = FileTypeEnum._02)
public class AppServiceTwoImpl implements AppService {
    @Override
    public void print() {
        System.out.println("two");
    }
}
