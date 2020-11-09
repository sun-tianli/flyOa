package com.eaglesoft.zjhz.entity.vo;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "jcZwglRequest", description = "jcZwgl请求类")
public class jcZwglRequest {
    @ApiModelProperty(value = "编号")
    private Integer bh;

    @ApiModelProperty(value = "职务名称")
    private String zwmc;

    @ApiModelProperty(value = "所属单位编号")
    private Integer dwbh;

    @ApiModelProperty(value = "删除标志，0未删除，1已删除")
    private Integer scbz;

}
