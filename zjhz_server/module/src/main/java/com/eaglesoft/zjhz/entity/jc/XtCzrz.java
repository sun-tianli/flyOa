package com.eaglesoft.zjhz.entity.jc;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="XtCzrz对象", description="操作日志表")
public class XtCzrz extends Model<XtCzrz> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "BH", type = IdType.AUTO)
    private Integer bh;

    @ApiModelProperty(value = "操作人")
    @TableField("CZR")
    private Integer czr;

    @ApiModelProperty(value = "操作时间")
    @TableField("CZSJ")
    private LocalDateTime czsj;

    @ApiModelProperty(value = "操作内容")
    @TableField("CZNR")
    private String cznr;

    @ApiModelProperty(value = "操作IP")
    @TableField("CZIP")
    private String czip;

    @ApiModelProperty(value = "表单编号")
    @TableField("BDBH")
    private Integer bdbh;

    @ApiModelProperty(value = "数据编号")
    @TableField("SJBH")
    private Integer sjbh;

    @ApiModelProperty(value = "提交参数")
    @TableField("TJCS")
    private String tjcs;

    @ApiModelProperty(value = "操作类")
    @TableField("CZCLASS")
    private String czclass;

    @ApiModelProperty(value = "操作方法")
    @TableField("CZFF")
    private String czff;

    @ApiModelProperty(value = "所属单位编号")
    @TableField("DWBH")
    private Integer dwbh;


    @Override
    protected Serializable pkVal() {
        return this.bh;
    }

}
