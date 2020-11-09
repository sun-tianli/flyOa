package com.eaglesoft.zjhz.entity.vo;


import lombok.Data;

import java.util.List;

@Data
public class JcJsglTree {
    private Integer bh;
    private List<JcYhglTree> children;
    private Integer dwbh;
    private String jsmc;
    private List<Integer> power;

}
