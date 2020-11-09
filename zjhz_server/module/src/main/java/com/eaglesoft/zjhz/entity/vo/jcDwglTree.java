package com.eaglesoft.zjhz.entity.vo;

import com.eaglesoft.zjhz.entity.jc.JcBmgl;
import com.eaglesoft.zjhz.entity.jc.JcDwgl;
import lombok.Data;

import java.util.List;

@Data
public class jcDwglTree {
    private Integer dwbh;
    private List<jcBmglTree> bmChild;
    private List<jcDwglTree> dwChild;
    private String dwmc;
    //就是父节点
    private Integer sjdw;
    private Integer wzh;
    private Integer Lft;
    private Integer Rgt;
}
