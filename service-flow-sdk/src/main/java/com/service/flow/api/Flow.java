package com.service.flow.api;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author zhangcb
 * @ClassName Flow.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface Flow {

    String name();

    FlowTypeEnum type() default FlowTypeEnum.METHOD;

    String desc() default "";
}
