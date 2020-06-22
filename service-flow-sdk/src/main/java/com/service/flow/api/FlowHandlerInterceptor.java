package com.service.flow.api;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowHandlerInterceptor.java
 * @Description 自定义拦截器接口
 * @createTime 2020年06月22日 06:49:00
 */
public interface FlowHandlerInterceptor {
    Map<String,Object> beforeHandle();
    Map<String,Object> afterHandle();
    Map<String,Object> ExceptionHandle();
}
