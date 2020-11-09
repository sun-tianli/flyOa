package com.eaglesoft.zjhz.common.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;

    /*private int pageSize = 10;
    private int pageNum = 1;

    private String sortField;
    private String sortOrder;*/

    @ApiModelProperty("当前页数")
    private Integer pageIndex = 1;

    @ApiModelProperty("每页条数")
    private Integer pageSize = 10;

    @ApiModelProperty("单行刷新id")
    private Object id;

    /*@ApiModelProperty("排序")
    private String orderBy;

    @ApiModelProperty("排序，可以多个，以逗号隔开，对应orderBy")
    private String sortType;*/

    @ApiModelProperty("排序(数组)")
    private List<OrderByVo> orders;
}
