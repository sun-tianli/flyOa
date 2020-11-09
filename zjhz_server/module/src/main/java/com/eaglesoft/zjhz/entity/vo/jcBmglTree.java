package com.eaglesoft.zjhz.entity.vo;

import com.eaglesoft.zjhz.entity.jc.JcBmgl;
import lombok.Data;

import java.util.List;

@Data
public class jcBmglTree {
    private Integer bmbh;
    private List<jcBmglTree> child;
    private String bmmc;
    //也是父节点
    private Integer dwbh;
    //就是父节点
    private Integer sjbm;
    private Integer wzh;
    private Integer Lft;
    private Integer Rgt;

}
