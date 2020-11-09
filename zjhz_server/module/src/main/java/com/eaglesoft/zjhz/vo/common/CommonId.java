package com.eaglesoft.zjhz.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "CommonId", description = "ID通用请求类")
@Data
public class CommonId extends BaseLogParamReq{
    @ApiModelProperty("通用入参类")
    private Long id;
}
