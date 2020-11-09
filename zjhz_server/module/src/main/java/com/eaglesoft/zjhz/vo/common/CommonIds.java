package com.eaglesoft.zjhz.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "CommonIds", description = "ID通用请求类")
@Data
public class CommonIds {

    @ApiModelProperty("通用入参类")
    private String ids;
}
