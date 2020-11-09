package com.eaglesoft.zjhz.common.config;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @description: jasypt安全框架配置
 * @author: caicy
 * @create: 2019-08-19 14:07
 */
@Configuration
public class JasyptConfiguration {
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(Environment environment) {
        return new JasyptStringEncryptor();
    }
}
