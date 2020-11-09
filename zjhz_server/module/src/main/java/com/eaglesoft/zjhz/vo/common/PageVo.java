package com.eaglesoft.zjhz.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页
 * Created by lx on 2019/9/2
 */
@ApiModel(value = "PagesVo", description = "分页实体")
@Data
public class PageVo<T> extends BaseLogParamReq{
    @ApiModelProperty("数据")
    private List<T> rows;
    @ApiModelProperty("总条数")
    private Long total;
    @ApiModelProperty("总页数")
    private Long totalPage;
}
