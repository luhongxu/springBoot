package com.lu.common.config;

import java.lang.annotation.*;

/**
 * 系统日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 模块
     */
    String module() default "";

    /**
     * 主要内容
     */
    String value() default "";

    /**
     * 是否记录库
     */
    boolean dbFlag() default false;
}
