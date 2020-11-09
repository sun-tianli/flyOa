package com.eaglesoft.zjhz.entity.jc;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 门户-菜单管理
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MhCdgl对象", description="门户-菜单管理")
public class MhCdgl extends Model<MhCdgl> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "BH", type = IdType.AUTO)
    private Integer bh;

    @ApiModelProperty(value = "菜单名称")
    @TableField("CDMC")
    private String cdmc;

    @ApiModelProperty(value = "图标图片，存url")
    @TableField("TBTP")
    private String tbtp;

    @ApiModelProperty(value = "链接方式，0在新窗口打开，1在本窗口打开，2在框架中打开，3在层中打开")
    @TableField("LJFS")
    private Integer ljfs;

    @ApiModelProperty(value = "链接地址，如有特殊参数需传递，用特殊写法直接写在链接中")
    @TableField("LJDZ")
    private String ljdz;

    @ApiModelProperty(value = "宽度")
    @TableField("KD")
    private Integer kd;

    @ApiModelProperty(value = "高度")
    @TableField("GD")
    private Integer gd;

    @ApiModelProperty(value = "上级菜单")
    @TableField("SJCD")
    private Integer sjcd;

    @ApiModelProperty(value = "状态，0启用，1禁用")
    @TableField("JYZT")
    private Integer jyzt;

    @ApiModelProperty(value = "位置号")
    @TableField("WZH")
    private Integer wzh;

    @ApiModelProperty(value = "所属单位编号，-1代表为全局使用")
    @TableField("DWBH")
    private Integer dwbh;


    @Override
    protected Serializable pkVal() {
        return this.bh;
    }

}
