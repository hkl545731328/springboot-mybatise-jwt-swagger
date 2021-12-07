package com.example.demo.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.exception.SpringException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: micor-mantis-basic-service-parent
 * @ClassName GlobalHandler
 * @description: 全局异常处理器
 * @author: 尹斌
 * @create: 2020-11-02 20:07
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GlobalHandler {


    @ExceptionHandler(SpringException.class)
    public JSONObject handlePaymentException(SpringException e){
        JSONObject result = new JSONObject();
        String content = RequestThreadLocal.getAlarmRequestParam() == null ? null : "请求参数：".concat(RequestThreadLocal.getAlarmRequestParam());
        RequestThreadLocal.clearAlarmRequestParam();
        if (content == null) {
            content = e.getCause() == null ? null : "异常消息：".concat(e.getCause().getMessage());
        }else {
            content = e.getCause() == null ? content : content.concat("\n异常消息：").concat(e.getCause().getMessage());
        }
        log.error("异常告警：{}",content);
        result.put("code",e.getCode());
        result.put("message",e.getMessage());
        return result;
    }
}
