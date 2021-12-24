package com.example.demo.study.future.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 *
 *
 * @author: hkl
 * @create: 2021-12-24 15:19
 **/
@Service
public class FutureService {

    @Async
    public Future<String> test() throws Exception{
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+ " :2222");
        return new AsyncResult<String>("1111") ;
    }
}
