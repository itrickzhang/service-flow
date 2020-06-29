package com.service.flow.api;

import java.lang.annotation.*;

/**
 * @author zhangcb
 * @ClassName Flow.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
public @interface DTO {

    String value() default "";

    String desc() default "";
}
