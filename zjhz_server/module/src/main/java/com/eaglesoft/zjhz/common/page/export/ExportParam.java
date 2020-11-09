package com.eaglesoft.zjhz.common.page.export;

import cn.eaglesoft.tools.excelUtil.entity.Columns;
import com.eaglesoft.zjhz.common.page.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 导出参数
 * Created by lx on 2019/3/21
 */
@ApiModel(value = "ExportParam", description = "需要导出的继承对象--请求时候继承")
public class ExportParam extends QueryRequest {

    @ApiModelProperty("参数列表")
    public List<Columns> columns;

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }
}
