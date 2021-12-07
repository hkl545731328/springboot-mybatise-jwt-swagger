package com.example.demo.handler;

import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * @author hkl
 * @date 下午5:08 2021/12/6
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestThreadLocal {

    private static final ThreadLocal<String> alarmRequestParamThreadLocal = new ThreadLocal<>();

    public static String getAlarmRequestParam() {
        return alarmRequestParamThreadLocal.get();
    }

    public static void setAlarmRequestParam(Object object) {
        alarmRequestParamThreadLocal.set(JSON.toJSONString(object));
    }

    public static void clearAlarmRequestParam() {
        alarmRequestParamThreadLocal.remove();
    }
}
