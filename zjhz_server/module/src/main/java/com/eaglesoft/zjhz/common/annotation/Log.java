package com.eaglesoft.zjhz.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * 要执行的功能查模块，如：用户管理
     * @return
     */
    String value() default "";

    /**
     * 要执行的具体操作，比如：添加用户
     *
     **/
    String operationName() default "";

    /**
     * 要执行的操作类型，比如：add操作
     **/
    int operationType() default 0;//0未知，1增，2改，3删，
}
