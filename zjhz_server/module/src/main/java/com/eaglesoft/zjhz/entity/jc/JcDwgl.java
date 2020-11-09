package com.eaglesoft.zjhz.entity.jc;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设置所有使用OA系统的单位架构信息，如果是集团版一般会有多家单位
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "JcDwgl对象", description = "设置所有使用OA系统的单位架构信息，如果是集团版一般会有多家单位")
public class JcDwgl extends Model<JcDwgl> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "BH", type = IdType.AUTO)
    private Integer bh;

    @ApiModelProperty(value = "单位名称")
    @TableField("DWMC")
    private String dwmc;

    @ApiModelProperty(value = "上级单位编号")
    @TableField("SJDW")
    private Integer sjdw;

    @ApiModelProperty(value = "位置号")
    @TableField("WZH")
    private Integer wzh;

    @ApiModelProperty(value = "左边层级数，用于查询树的优化")
    @TableField("Lft")
    private Integer Lft;

    @ApiModelProperty(value = "右边层级数，用于查询树的优化")
    @TableField("Rgt")
    private Integer Rgt;

    @ApiModelProperty(value = "删除标志，0未删除，1已删除")
    @TableField("SCBZ")
    private Integer scbz;
    //子节点
//    @TableField(exist = false)
//    private List<JcBmgl> chlidren;


    @Override
    protected Serializable pkVal() {
        return this.bh;
    }

}
