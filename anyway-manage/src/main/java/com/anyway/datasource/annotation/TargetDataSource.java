package com.anyway.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author: wang_hui
 * @date: 2018/5/30 下午5:49
 * @since: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name() default "";
}
