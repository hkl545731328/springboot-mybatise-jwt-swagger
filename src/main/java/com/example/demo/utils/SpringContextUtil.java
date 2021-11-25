package com.example.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;// Spring应用上下文环境

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static <T> T getBean(String name) throws BeansException{
        return (T)applicationContext.getBean(name);
    }

    public static <T> Map<String,T> getBeansOfType(Class<T> type){
        return applicationContext.getBeansOfType(type);
    }

    public static <T> T getBean(String name,Class<T> requiredType)throws BeansException{
        return applicationContext.getBean(name,requiredType);
    }
}
