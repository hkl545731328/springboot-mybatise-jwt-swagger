package com.example.demo.controller;

import com.example.demo.models.CommonResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "swagger测试接口")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {


    @ApiOperation(value = "get请求")
    @GetMapping(value = "/test")
    public CommonResp test( @ApiParam(value = "日期") @RequestParam(value = "date", required = false) String date,
                            @ApiParam(value = "卡片id") @RequestParam(value = "cardId", required = false) String cardId){
        System.out.println(date);
        System.out.println(cardId);
        CommonResp resp = new CommonResp(0,"success",null);
        return resp;
    }
}
