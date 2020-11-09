package com.eaglesoft.zjhz.vo.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @作者：huchengjie
 * @时间：2019/10/24 1:35 PM
 * @功能：
 */
@Data
@ApiModel(value = "BaseLogParamReq", description = "记录日志请求参数")
public class BaseLogParamReq {
    @ApiModelProperty("日志记录请求数据")
    @TableField(exist = false)
    @JSONField(serialize = false)
    private BaseLogParamList logData;
}
