package com.service.flow.api;

/**
 * @author zhangcb
 * @ClassName FlowTypeEnum.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public enum FlowTypeEnum {

    METHOD("method"),
    SERVICE("service");

    private String value;

    FlowTypeEnum(String value){
        this.value = value;
    }
}
