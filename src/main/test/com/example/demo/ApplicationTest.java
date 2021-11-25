package com.example.demo;

//import com.example.demo.enums.FileTypeEnum;
//import com.example.demo.study.applicationContext.factorys.FileHandlerFactory;
//import com.example.demo.study.applicationContext.service.AppService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.enums.FileTypeEnum;
import com.example.demo.study.applicationContext.configs.AppConfig;
import com.example.demo.study.applicationContext.factorys.FileHandlerFactory;
import com.example.demo.study.applicationContext.service.AppService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class ApplicationTest {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private FileHandlerFactory fileHandlerFactory;

    @Test
    void testApplicationContext(){
        AppService appService = fileHandlerFactory.get(FileTypeEnum._01);
        appService.print();
    }
    @Test
    void test1() throws Exception {
        AppService appService = appConfig.get(FileTypeEnum._01);
        appService.print();
    }
}
