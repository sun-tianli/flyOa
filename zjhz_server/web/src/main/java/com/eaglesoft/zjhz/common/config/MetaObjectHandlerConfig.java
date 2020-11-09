package com.eaglesoft.zjhz.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("cjsj", metaObject);
        Object updateTime = getFieldValByName("gxsj", metaObject);
        if (createTime == null)
            setFieldValByName("cjsj",LocalDateTime.now(), metaObject);//mybatis-plus版本2.0.9+
        if (updateTime == null)
            setFieldValByName("gxsj",LocalDateTime.now(), metaObject);//mybatis-plus版本2.0.9+*/
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("gxsj", metaObject);
        if (updateTime == null) {
            setFieldValByName("gxsj",LocalDateTime.now(), metaObject);//mybatis-plus版本2.0.9+
        }
    }
}