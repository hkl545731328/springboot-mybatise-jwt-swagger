package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileTypeEnum {

    _01("01",new String[]{"01","LT01"},"账户申请"),
    _02("02",new String[]{"02","LT02"},"账户确认"),
    ;
    private String code;
    private String[] detailCode;
    private String description;


}
