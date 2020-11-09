package com.eaglesoft.zjhz.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="jsglBh",description = "jsglBh")
public class power {
    private Integer[] currentPower;
    private Integer[] oldPower;
    private Integer[] addarray;
    private Integer[] nonearray;
    private Integer jsbh;
}
