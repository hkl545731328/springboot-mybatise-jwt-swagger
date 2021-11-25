package com.example.demo.study.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;

    private Integer age;

    private Integer salary;

    private Status status;
}
