package com.eaglesoft.zjhz.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "selectDwmc", description = "搜索单位名称请求类")
public class selectDwmc {


    @ApiModelProperty(value = "单位名称")
    private String dwmc;

}
