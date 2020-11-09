package com.eaglesoft.zjhz.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "selectZw", description = "搜索职务名称请求类")
public class selectZw {
    @ApiModelProperty(value = "职务名称")
    private String zwmc;
    @ApiModelProperty(value = "位置号")
    private Integer wzh;
    @ApiModelProperty(value = "编号")
    private Integer bh;

}
