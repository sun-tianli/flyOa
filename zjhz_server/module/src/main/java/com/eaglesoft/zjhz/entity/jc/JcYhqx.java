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
 * 用户权限
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="JcYhqx对象", description="用户权限")
public class JcYhqx extends Model<JcYhqx> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "BH", type = IdType.AUTO)
    private Integer bh;

    @ApiModelProperty(value = "所属用户编号")
    @TableField("YHBH")
    private Integer yhbh;

    @ApiModelProperty(value = "权限编号")
    @TableField("QXBH")
    private Integer qxbh;

    @ApiModelProperty(value = "所属单位编号")
    @TableField("DWBH")
    private Integer dwbh;


    @Override
    protected Serializable pkVal() {
        return this.bh;
    }

}
