package com.eaglesoft.zjhz.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="职务数组",description = "职务数组")
public class setRequestByQx {
    private Integer dwbh;

    private Integer qxbh;

    Integer[] jsArr;

}
