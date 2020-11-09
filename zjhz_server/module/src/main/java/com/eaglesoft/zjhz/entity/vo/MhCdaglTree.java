package com.eaglesoft.zjhz.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class MhCdaglTree {
    private Integer bh;
    private String cdmc;
    private String ljdz;
    private String tbtp;
    private Integer wzh;
    private List<MhCdaglTree> children;
    private List<Integer> jslist;
    private List<Integer> yhlist;

}
