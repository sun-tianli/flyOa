package com.eaglesoft.zjhz.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
@ApiModel(value = "YhXm", description = "用户管理返回类")//没用上
public class YhXm {
    @ApiModelProperty(value = "用户姓名")
    private String xm;
}
