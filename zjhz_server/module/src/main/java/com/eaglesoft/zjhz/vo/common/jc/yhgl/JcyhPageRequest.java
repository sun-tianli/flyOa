package com.eaglesoft.zjhz.vo.common.jc.yhgl;

import com.eaglesoft.zjhz.common.page.export.ExportParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @作者：huchengjie
 * @时间：2019/12/18 3:40 PM
 * @功能：
 */
@ApiModel(value = "JcyhPageRequest", description = "用户分页查询入参类")
@Data
public class JcyhPageRequest extends ExportParam {
    @ApiModelProperty("查询条件")
    private String query;
}
