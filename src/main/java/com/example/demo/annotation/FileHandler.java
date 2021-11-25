package com.example.demo.annotation;

import com.example.demo.enums.FileTypeEnum;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
@Component
public @interface FileHandler {

    @AliasFor(annotation = Component.class,value = "value")
    String componentName() default "";

    FileTypeEnum fileType();

}
