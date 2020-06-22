package com.service.flow.model;

/**
 * @author zhangcb
 * @ClassName Node.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public class Node {

    //节点标识
    private String id;

    //节点名称
    private String name;

    //节点描述
    private String desc;

    //节点输入
    private String input;

    //节点类型
    private String type;

    //下一个节点标识
    private String next;

    //路径
    private String component;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", input='" + input + '\'' +
                ", type='" + type + '\'' +
                ", next='" + next + '\'' +
                ", component='" + component + '\'' +
                '}';
    }
}
