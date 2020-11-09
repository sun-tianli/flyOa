package com.eaglesoft.zjhz.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class jcDwglChild {

    private Integer dwbh;
    private List<jcDwglChild> Children;
    private String dwmc;
    //就是父节点
    private Integer sjdw;
    private Integer wzh;
    private Integer Lft;
    private Integer Rgt;
}
