package com.eaglesoft.zjhz.entity.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="save数组",description = "save数组")
public class saveRequest {
    private Integer dwbh;

    private Integer bh;

    Integer[] arr;

}
