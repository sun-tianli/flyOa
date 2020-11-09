package com.eaglesoft.zjhz.vo.common.jc.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @作者：huchengjie
 * @时间：2019/12/18 11:27 AM
 * @功能：
 */
@ApiModel(value = "LoginResult", description = "登录返回")
@Data
public class LoginResult {
    @ApiModelProperty("Token")
    private String token;

    @ApiModelProperty("用户信息")
    private String username;
}
