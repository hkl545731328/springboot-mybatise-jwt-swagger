package com.example.demo.study.applicationContext.configs;

import com.example.demo.annotation.FileHandler;
import com.example.demo.enums.FileTypeEnum;
import com.example.demo.study.applicationContext.service.AppService;
import com.example.demo.utils.SpringContextUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class AppConfig implements InitializingBean {
    private Map<FileTypeEnum,AppService> allServiceMap = new HashMap<>();

    @Autowired
    ApplicationContext applicationContext;

//    @PostConstruct
//    public void afterPropertiesSet() throws Exception {
//        Map<String, AppService> beansOfType = applicationContext.getBeansOfType(AppService.class);
//        System.out.println(beansOfType);
//        beansOfType.values().forEach(e ->{
//            allServiceMap.put(e.getClass().getAnnotation(FileHandler.class).fileType(),e);
//        });
//    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, AppService> beansOfType = applicationContext.getBeansOfType(AppService.class);
        System.out.println(beansOfType);
        beansOfType.values().forEach(e ->{
            allServiceMap.put(e.getClass().getAnnotation(FileHandler.class).fileType(),e);
        });
    }

    public AppService get(FileTypeEnum type){
        return allServiceMap.get(type);
    }
}
