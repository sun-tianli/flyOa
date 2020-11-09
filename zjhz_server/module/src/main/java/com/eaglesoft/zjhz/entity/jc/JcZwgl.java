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
 * 职务管理
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="JcZwgl对象", description="职务管理")
public class JcZwgl extends Model<JcZwgl> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "BH", type = IdType.AUTO)
    private Integer bh;

    @ApiModelProperty(value = "职务名称")
    @TableField("ZWMC")
    private String zwmc;

    @ApiModelProperty(value = "所属单位编号")
    @TableField("DWBH")
    private Integer dwbh;

    @ApiModelProperty(value = "位置号")
    @TableField("WZH")
    private Integer wzh;

    @ApiModelProperty(value = "删除标志，0未删除，1已删除")
    @TableField("SCBZ")
    private Integer scbz;


    @Override
    protected Serializable pkVal() {
        return this.bh;
    }

}
