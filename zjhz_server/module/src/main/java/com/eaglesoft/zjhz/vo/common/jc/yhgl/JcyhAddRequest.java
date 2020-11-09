package com.eaglesoft.zjhz.vo.common.jc.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @作者：huchengjie
 * @时间：2019/12/19 8:57 AM
 * @功能：
 */
@ApiModel(value = "JcyhAddReq", description = "用户新增请求类")
@Data
public class JcyhAddRequest {
    @ApiModelProperty(value = "编号")
    private Integer bh;

    @ApiModelProperty(value = "帐号")
    @NotNull(message = "账户不能为空")
    private String zh;

    @ApiModelProperty(value = "姓名")
    private String xm;

    @ApiModelProperty(value = "电话")
    private String dh;

    @ApiModelProperty(value = "手机")
    private String sj;
}
