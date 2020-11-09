package com.eaglesoft.zjhz.entity.vo;


import com.eaglesoft.zjhz.entity.jc.JcJsgl;
import lombok.Data;

import java.util.List;

@Data
public class findUserTree {
    private String dwmc;
    private List<JcJsglTree> jcJsgls;

}


