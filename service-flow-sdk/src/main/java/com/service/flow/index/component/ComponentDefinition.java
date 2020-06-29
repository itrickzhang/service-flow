package com.service.flow.index.component;


import com.service.flow.index.dto.DTODefinition;

/**
 * @author zhangcb
 * @ClassName ComponentDefinition.java
 * @Description TODO
 * @createTime 2020年06月29日 07:15:00
 */
public class ComponentDefinition {

    private String value;

    private String desc;

    private String className;

    private String methodName;

    private DTODefinition dtoDefinition;

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

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public DTODefinition getDtoDefinition() {
        return dtoDefinition;
    }

    public void setDtoDefinition(DTODefinition dtoDefinition) {
        this.dtoDefinition = dtoDefinition;
    }

    @Override
    public String toString() {
        return "ComponentDefinition{" +
                "value='" + value + '\'' +
                ", desc='" + desc + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", dtoDefinition=" + dtoDefinition +
                '}';
    }
}
