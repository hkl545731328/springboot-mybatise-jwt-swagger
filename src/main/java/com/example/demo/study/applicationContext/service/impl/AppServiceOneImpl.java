package com.example.demo.study.applicationContext.service.impl;

import com.example.demo.annotation.FileHandler;
import com.example.demo.enums.FileTypeEnum;
import com.example.demo.study.applicationContext.service.AppService;

@FileHandler(componentName = "appServiceOne",fileType = FileTypeEnum._01)
public class AppServiceOneImpl implements AppService {

    @Override
    public void print() {
        System.out.println("one");
    }
}
