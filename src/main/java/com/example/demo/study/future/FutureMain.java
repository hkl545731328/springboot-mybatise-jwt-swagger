package com.example.demo.study.future;

import com.example.demo.study.future.service.FutureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 *
 *
 * @author: hkl
 * @create: 2021-12-24 15:24
 **/
@Component
public class FutureMain {
    @Autowired
    private FutureService futureService;

    public void printStr() throws Exception{

        long startTime = System.currentTimeMillis();

        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Future<String> test = futureService.test();
            list.add(test);
        }

        StringBuffer result = new StringBuffer();
        for (Future<String> stringFuture : list) {
            while (!stringFuture.isDone());
            String s = stringFuture.get();
            System.out.println(s);
            result.append(s);

        }

        long processTime = (System.currentTimeMillis() - startTime)/1000;
        System.out.println(processTime);
        System.out.println(result);

    }
}
