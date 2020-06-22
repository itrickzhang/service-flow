package com.service.flow.support.yml;

import java.util.List;

/**
 * @author zhangcb
 * @ClassName Flow.java
 * @Description 流程对应的yml模型
 * @createTime 2020年06月21日 15:38:00
 */
public class YmlFlow {

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

    //流程节点
    private List<TempNode> nodes;

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

    public List<TempNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TempNode> nodes) {
        this.nodes = nodes;
    }


    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", temp='" + temp + '\'' +
                ", desc='" + desc + '\'' +
                ", startNode='" + startNode + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
