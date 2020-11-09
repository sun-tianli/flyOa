package com.eaglesoft.zjhz.entity.vo;


import com.eaglesoft.zjhz.common.page.QueryRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class XtCzrzPage extends QueryRequest {
    @ApiModelProperty("查询条件")
    private Integer query;
}
