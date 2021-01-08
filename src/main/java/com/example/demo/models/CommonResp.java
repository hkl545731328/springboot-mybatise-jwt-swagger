package com.example.demo.models;

import com.example.demo.jsonview.ObjectJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("请求返回")
public class CommonResp<T> {

    @ApiModelProperty(value = "结果编码", required = true)
    @Getter
    @Setter
    @JsonView(value = {ObjectJsonView.GetOperatorResultView.class,
            ObjectJsonView.AuthResultView.class,
            ObjectJsonView.ShareObjectOfGradeResultView.class,
            ObjectJsonView.ShareObjectOfTeacherResultView.class})
    protected Integer resultCode;

    @ApiModelProperty(value = "结果说明", required = true)
    @Getter
    @Setter
    @JsonView(value = {ObjectJsonView.GetOperatorResultView.class,
            ObjectJsonView.AuthResultView.class,
            ObjectJsonView.ShareObjectOfGradeResultView.class,
            ObjectJsonView.ShareObjectOfTeacherResultView.class})
    protected String resultDesc;

    @ApiModelProperty(value = "具体结果对象", required = true)
    @Getter
    @Setter
    @JsonView(value = {ObjectJsonView.GetOperatorResultView.class,
            ObjectJsonView.AuthResultView.class,
            ObjectJsonView.ShareObjectOfGradeResultView.class,
            ObjectJsonView.ShareObjectOfTeacherResultView.class})
    protected T data;

    public CommonResp() {

    }

    public CommonResp(Integer code, String desc, T data) {
        this.resultCode = code;
        this.resultDesc = desc;
        this.data = data;
    }

    /**
     * 成功的操作
     *
     * @param data
     */
    public CommonResp(T data) {
        this.resultCode = 0;
        this.resultDesc = "成功";
        this.data = data;
    }
}
