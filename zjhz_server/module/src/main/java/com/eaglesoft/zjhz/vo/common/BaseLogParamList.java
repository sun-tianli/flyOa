package com.eaglesoft.zjhz.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @作者：huchengjie
 * @时间：2019/10/24 9:20 AM
 * @功能：
 */
@Data
@ApiModel(value = "BaseLogParamList", description = "记录日志数组类")
public class BaseLogParamList {
    @ApiModelProperty("日志记录数组数据")
    private List<BaseLogParam> data;

    @ApiModelProperty("日志记录页面名称")
    private String page;

    @ApiModelProperty("自定义日志内容，有了log就忽略data")
    private String log;
}
