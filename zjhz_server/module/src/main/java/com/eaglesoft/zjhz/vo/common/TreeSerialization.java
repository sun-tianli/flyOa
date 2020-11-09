package com.eaglesoft.zjhz.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel(value = "TreeSerialization", description = "通用树形结构")
@Data
public class TreeSerialization{

    @ApiModelProperty("主键id")
    private String nodeId;


    @ApiModelProperty("父节点id")
    private String nodePId;

    @ApiModelProperty("节点名称")
    private String nodeName;

    @ApiModelProperty("子节点列表")
    private List child;

    @ApiModelProperty("节点类型")
    private String type;
}