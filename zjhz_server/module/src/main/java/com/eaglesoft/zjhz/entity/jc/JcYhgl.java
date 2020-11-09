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
 * 用户管理
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="JcYhgl对象", description="用户管理")
public class JcYhgl extends Model<JcYhgl> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "BH", type = IdType.AUTO)
    private Integer bh;

    @ApiModelProperty(value = "帐号")
    @TableField("ZH")
    private String zh;

    @ApiModelProperty(value = "MD5加密后的帐号")
    @TableField("ZH_MD5")
    private String zhMd5;

    @ApiModelProperty(value = "密码，md5加密")
    @TableField("MM")
    private String mm;

    @ApiModelProperty(value = "姓名")
    @TableField("XM")
    private String xm;

    @ApiModelProperty(value = "姓名拼音")
    @TableField("XMPY")
    private String xmpy;

    @ApiModelProperty(value = "头像，存base64")
    @TableField("TX")
    private String tx;

    @ApiModelProperty(value = "电话")
    @TableField("DH")
    private String dh;

    @ApiModelProperty(value = "手机")
    @TableField("SJ")
    private String sj;

    @ApiModelProperty(value = "虚拟网")
    @TableField("XNW")
    private String xnw;

    @ApiModelProperty(value = "邮箱")
    @TableField("YX")
    private String yx;

    @ApiModelProperty(value = "所属部门")
    @TableField("BM")
    private Integer bm;

    @ApiModelProperty(value = "所属职务")
    @TableField("ZW")
    private Integer zw;

    @ApiModelProperty(value = "所属角色")
    @TableField("JS")
    private Integer js;

    @ApiModelProperty(value = "上级领导编号")
    @TableField("SJLD")
    private Integer sjld;

    @ApiModelProperty(value = "微信绑定ID")
    @TableField("WXBDID")
    private String wxbdid;

    @ApiModelProperty(value = "所属单位编号")
    @TableField("DWBH")
    private Integer dwbh;

    @ApiModelProperty(value = "位置号")
    @TableField("WZH")
    private Integer wzh;

    @ApiModelProperty(value = "禁用状态，0启用，1禁用")
    @TableField("JYZT")
    private Integer jyzt;

    @ApiModelProperty(value = "删除标志，0未删除，1已删除")
    @TableField("SCBZ")
    private Integer scbz;

    @ApiModelProperty(value = "是否是超级管理员，0不是超级管理员，1是超级管理员")
    @TableField("ISCJGL")
    private Integer iscjgl;


    @Override
    protected Serializable pkVal() {
        return this.bh;
    }

}
