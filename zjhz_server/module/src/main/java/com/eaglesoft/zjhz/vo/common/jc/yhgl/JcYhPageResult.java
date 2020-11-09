package com.eaglesoft.zjhz.vo.common.jc.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @作者：huchengjie
 * @时间：2019/12/18 3:32 PM
 * @功能：
 */
@ApiModel(value = "JcYhPageResult", description = "用户分页返回数据")
@Data
public class JcYhPageResult {
    @ApiModelProperty("用户名")
    private String zh;
    @ApiModelProperty("用户id")
    private String id;
}
