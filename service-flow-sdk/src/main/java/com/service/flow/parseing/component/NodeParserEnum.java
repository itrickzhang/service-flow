package com.service.flow.parseing.component;

/**
 * @author zhangcb
 * @ClassName NodeParserEnum.java
 * @Description TODO
 * @createTime 2020年06月19日 08:28:00
 */
public enum NodeParserEnum {
    method("method"),
    bean("bean"),
    condition("condition"),
    service("service"),
    subflow("subflow");

    private String value;

    NodeParserEnum(String value){
        this.value = value;
    }
}
