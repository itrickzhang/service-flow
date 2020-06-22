package com.service.flow.model;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowDefintition.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public class FlowDefintition {
    //流程标识
    private String id;

    //流程名称
    private String name;

    //请求参数
    private String input;

    //输出参数
    private String output;

    //临时变量
    private String temp;

    //流程描述
    private String desc;

    //开启节点
    private String startNode;

    //子流程节点
    private Map<String,Node> nodeMap;

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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public Map<String, Node> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }

    @Override
    public String toString() {
        return "FlowDefintition{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", temp='" + temp + '\'' +
                ", desc='" + desc + '\'' +
                ", startNode='" + startNode + '\'' +
                ", nodeMap=" + nodeMap +
                '}';
    }
}
