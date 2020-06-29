package com.service.flow.index.dto;


/**
 * @author zhangcb
 * @ClassName DTODefinition.java
 * @Description TODO
 * @createTime 2020年06月29日 07:15:00
 */
public class DTODefinition {

    private String value;

    private String desc;

    private String className;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "DTODefinition{" +
                "value='" + value + '\'' +
                ", desc='" + desc + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
