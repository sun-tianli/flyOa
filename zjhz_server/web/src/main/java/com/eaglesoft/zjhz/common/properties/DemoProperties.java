package com.eaglesoft.zjhz.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="demo")
public class DemoProperties {

     private boolean openAopLog = true;

     /**
      * token过期时间
      */
     Long jwtTimeOut = 86400L;

     Long otp = 60L;
}
