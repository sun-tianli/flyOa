package com.eaglesoft.zjhz.entity.vo;

import com.eaglesoft.zjhz.common.page.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "YhglPageRequest", description = "用户分页查询入参类")
@Data
public class YhglPage extends QueryRequest {
    @ApiModelProperty("查询条件")
    private Integer query;
}
