package com.example.demo;

import com.example.demo.study.future.FutureMain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *
 * @author: hkl
 * @create: 2021-12-24 15:39
 **/
public class FutureTest extends ApplicationTest{

    @Autowired
    private FutureMain futureMain;

    @Test
    void test1() throws Exception{
        futureMain.printStr();
    }
}
