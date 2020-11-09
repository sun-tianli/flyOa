package com.eaglesoft.zjhz.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @作者：huchengjie
 * @时间：2019/10/24 9:15 AM
 * @功能：
 */
@Data
@ApiModel(value = "BaseLogParam", description = "记录日志基础类")
public class BaseLogParam {
    @ApiModelProperty("字段中文名")
    private String label;
    @ApiModelProperty("老数据")
    private String before;
    @ApiModelProperty("新数据")
    private String after;
    @ApiModelProperty("字段名")
    private String key;

}
